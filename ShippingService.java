import java.util.List;

public class ShippingService {
    public static void ship(List<Shippable> products,List<Integer> quantities) {
        System.out.println("\nShippingService is processing the following items:");
        for (Shippable product:products ) {
            System.out.printf("- %s (%.2f g)%n", product.getName(), product.getWeight()* quantities.get(products.indexOf(product)));

        }
    }
}
