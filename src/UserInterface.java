import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserInterface {
    private User user;

    UserInterface(User user) {
        this.user = user;
    }

    public void startProcess(Scanner scanner) throws FileNotFoundException {
        Server server = Server.getInstance();
        server.printShopList();

        System.out.println("Print shop id you want to visit");
        int id = scanner.nextInt();

        AbstractShop shop = server.getShop(id);
        if (shop == null) startProcess(scanner);

        shop.printProducts();
        System.out.println("Print product you want to buy");
        String product = scanner.next();

        if (shop.sellProduct(product)) System.out.println("Thanks for the purchase!");
        else System.out.println("No such a product");
    }
}
