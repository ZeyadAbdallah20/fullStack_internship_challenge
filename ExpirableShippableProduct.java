import java.time.LocalDate;
public class ExpirableShippableProduct extends Product implements Expirable, Shippable {
    private LocalDate expirationDate;
    private double weight;

    public ExpirableShippableProduct(String name, double price, int quantity, LocalDate expirationDate, double weight) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
        this.weight = weight;
    }

    @Override
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getWeight() {
        return weight;
    }
    @Override
   public boolean isExpired() {
    return expirationDate.isBefore(LocalDate.now());
}
      
}
