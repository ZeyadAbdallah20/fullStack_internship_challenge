
import java.time.LocalDate;
public interface Expirable {
    void setExpirationDate(LocalDate ExpirationDate);   
    LocalDate getExpirationDate(); 
    boolean isExpired(); 
}