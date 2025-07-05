
import java.util.List;
public class Customer {

      private String name;
      private String phoneNumber;
      private double balance;
      private  Cart cart;
      double order_subtotal;
       double shipping_fees ;
       double paid_amount;
       List<Shippable> shippableProducts=new java.util.ArrayList<>();
       List<Integer> shippableProducts_quantities=new java.util.ArrayList<>();

     public Customer(String name, String phoneNumber, double balance) {
          this.name = name;
          this.phoneNumber = phoneNumber;
          this.balance = balance;
          this.cart = new Cart();
      }
      public void setName(String name) {
          this.name = name;
      }
      public void setPhoneNumber(String phoneNumber) {
          this.phoneNumber = phoneNumber;
      }
      public void setBalance(double balance) {
              if (balance < 0) {
                    throw new IllegalArgumentException("Balance cannot be negative.");
              }
          this.balance = balance;
      }
      public void setCart(Cart cart) {
          this.cart = cart;
      }

      public String getName() {
          return name;
      }

      public String getPhoneNumber() {
          return phoneNumber;
      }

      public double getBalance() {
          return balance;
      }

      public Cart getCart() {
          return cart;
      }

      public void addToCart(Product product, int quantity) {
          cart.addProduct(product, quantity);
      }
      public boolean isCartEmpty() {
          return cart.isEmpty();
      }
      public double calculateOrderSubtotal() {
              order_subtotal = 0;   
          for (CartProduct cartProduct : cart.getProducts()) {
              order_subtotal += cartProduct.product.getPrice() * cartProduct.quantity;
          }
          return order_subtotal;
      }
      public double calculateShippingFees() {
          shipping_fees = 0;
          for (CartProduct cartProduct : cart.getProducts()) {
              if (cartProduct.product instanceof Shippable) {
                  shipping_fees += ((Shippable) cartProduct.product).getWeight() * 0.005*cartProduct.quantity ; // Assuming a rate of $0.005 per weight unit
              }
          }
          return shipping_fees;
      }
    
     public double calculatePaidAmount() {
              paid_amount = calculateOrderSubtotal() + calculateShippingFees();
          return paid_amount;
      }
      public boolean canAffordOrder() {
          return balance >= calculatePaidAmount();
      }
      public void CheckOut() {
          if (isCartEmpty()) {
              System.out.println("Your cart is empty. Please add products to your cart before checking out.");
             return;
          } if(!canAffordOrder()){
              System.out.println("You don't have enough balance to checkout. Please add more funds to your account.");
             return;
            }
            for (CartProduct cartProduct : cart.getProducts()) {
                if (cartProduct.product instanceof Expirable) {
                  if (((Expirable) cartProduct.product).isExpired()) {
                      System.out.println("The product " + cartProduct.product.getName() + " is expired. Please remove it from your cart.");
                      return;
                  }     
                 
                }
            }
            for (CartProduct cartProduct : cart.getProducts()) {
                if (cartProduct.product.getQuantity()<cartProduct.quantity) {
                    System.out.println("The product " + cartProduct.product.getName() + " is out of stock. Please remove it from your cart.");
                    return;
                    
                }
            }

            

            for (CartProduct cartProduct : cart.getProducts()) {
        cartProduct.product.reduceQuantity(cartProduct.quantity);
    }

    
    balance -= calculatePaidAmount();

  
double totalWeight = 0;
    System.out.println("** Shipment notice **");
    for (CartProduct cp : cart.getProducts()) {
        if (cp.product instanceof Shippable) {
            double productWeight = ((Shippable) cp.product).getWeight() * cp.quantity;
            System.out.printf("%dx %-10s %.0fg%n", cp.quantity, cp.product.getName(), productWeight );
            totalWeight += productWeight;
           shippableProducts.add((Shippable) cp.product);
             shippableProducts_quantities.add(cp.quantity);
        }
    }
    System.out.printf("Total package weight %.1fkg%n%n", totalWeight/1000);

    System.out.println("** Checkout receipt **");
    for (CartProduct cp : cart.getProducts()) {
        double totalPrice = cp.product.getPrice() * cp.quantity;
        System.out.printf("%dx %-10s %.0f%n", cp.quantity, cp.product.getName(), totalPrice);
    }

    System.out.println("----------------------");
    System.out.printf("Subtotal%13.0f%n", calculateOrderSubtotal());
    System.out.printf("Shipping%13.0f%n", calculateShippingFees());
    System.out.printf("Amount%15.0f%n", calculatePaidAmount());
    ShippingService.ship(shippableProducts, shippableProducts_quantities);
  
}
           
         
      }
      

    

     


      

