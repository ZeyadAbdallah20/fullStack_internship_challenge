import java.time.LocalDate;
public class ExpirableProduct extends Product implements Expirable {
      LocalDate ExpirationDate;
      public ExpirableProduct(String name,double price,int quantity,LocalDate ExpirationDate){
           super(name,price,quantity);
            this.ExpirationDate=ExpirationDate;
      }

@Override
    public void setExpirationDate(LocalDate ExpirationDate) {
        this.ExpirationDate = ExpirationDate;
    }

@Override
    public LocalDate getExpirationDate() {
        return ExpirationDate;
    }
    public boolean isExpired() {
    return ExpirationDate.isBefore(LocalDate.now());
}
      

}
