public class ShippableProduct extends Product implements Shippable {
      double Weight;
      

     
      public ShippableProduct (String name, double price, int quantity, double weight) {
          super(name, price, quantity);
          this.Weight = weight;
      }
      
      public void setWeight(double weight) {
          this.Weight = weight;
      }
      @Override
      public String getName() {
          return super.getName();
      }
      @Override
      public double getWeight() {
          return Weight;
      }


   
   
      
}
