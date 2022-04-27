import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractShop extends AbstractUser {
    private Map<String, Integer> assortment;

    AbstractShop(String login, String password) {
        super(login, password);
        assortment = new HashMap<>();
    }

    public void addProduct(String product) {
        assortment.put(product, assortment.getOrDefault(product, 0) + 1);
    }

    public boolean hasProducts() {
        return !assortment.isEmpty();
    }

    public void printProducts(PrintWriter writer) {
        for (String key : assortment.keySet()) {
            for (int i = 0; i < assortment.get(key); i++) {
                writer.write(key + " ");
            }
        }
        writer.write("\n");
    }

    abstract String getShopType();
}
