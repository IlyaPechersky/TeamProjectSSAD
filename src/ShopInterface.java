import org.w3c.dom.ls.LSOutput;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShopInterface {
    private AbstractShop shop;

    ShopInterface(AbstractShop shop) {
        this.shop = shop;
    }

    public void startProcess(Scanner scanner) {
        System.out.println("Do you want add or remove product?(Print remove/add)");
        String sellOrBuy = scanner.next();

        if (sellOrBuy.equals("remove")) {
            shop.printProducts();
            System.out.println("Which product you want to remove?");
            String product = scanner.next();

            if (shop.sellProduct(product)) System.out.println("You deleted this product");
            else System.out.println("No such a product");
        } else {
            System.out.println("Which product you want to add?");
            String product = scanner.next();

            shop.addProduct(product);
            System.out.println("You successfully added this product to your assortment");
        }
    }
}
