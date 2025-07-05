import java.time.LocalDate;
public class Test {
      public static void main(String[] args) {
            /*========assume that shipping fees is 5 per 1kg =========*/

           Product laptop = new ShippableProduct("Laptop", 1000, 5,2000.0);
           Product cheese = new ExpirableShippableProduct("Cheese", 10, 10, LocalDate.of(2026, 12, 26), 500.0);
           Product Biscuits = new ExpirableProduct("Biscuits", 10, 10, LocalDate.of(2025, 12, 26));
           Product mobileScratchCards = new Product("mobileScratchCards", 100, 2);
           Customer customer = new Customer("ZEYAD", "0123456789", 10000.0);
          
           customer.addToCart(laptop, 1);
           customer.addToCart(cheese, 2);
           customer.addToCart(Biscuits, 3);
           customer.addToCart(mobileScratchCards, 1);/*if we put quantity more than available quantity message will be in console "The product mobileScratchCards is out of stock. Please remove it from your cart. */
           customer.CheckOut();

           

      }
      
}
