import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractShop extends AbstractUser {
    private Map<String, Integer> assortment;

    AbstractShop(String login, String password) {
        super(login, password);
        assortment = new HashMap<>();
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

    public void printProducts() {
        System.out.println("--------------------------------");
        for (String key : assortment.keySet()) {
            for (int i = 0; i < assortment.get(key); i++) {
                System.out.print(key + " ");
            }
        }
        System.out.println();
    }

    public void addProduct(String product) {
        assortment.put(product, assortment.getOrDefault(product, 0) + 1);
    }

    public boolean sellProduct(String product) {
        if (assortment.containsKey(product)) {
            assortment.put(product, assortment.get(product) - 1);
            if (assortment.get(product) == 0) assortment.remove(product);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return login;
    }

    abstract String getShopType();
}
