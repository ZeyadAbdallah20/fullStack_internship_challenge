import java.util.*;
public class Cart {
      private List<CartProduct> products;
      public Cart() {
          this.products = new ArrayList<>();
      }
      public void addProduct(Product product, int quantity) {
      
          CartProduct cartProduct = new CartProduct(product, quantity);
          products.add(cartProduct);
      } 
      public boolean isEmpty() {
          return products.isEmpty();
      }

      public List<CartProduct> getProducts() {
          return products;
      }
      
      
	  

	  
}
