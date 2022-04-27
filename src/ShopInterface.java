import org.w3c.dom.ls.LSOutput;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShopInterface {
    private AbstractShop shop;

    ShopInterface(AbstractShop shop) {
        this.shop = shop;
    }

    private void removeOrAdd(Scanner scanner) {
        System.out.println("Do you want add or remove product?(Print remove/add)");
        String sellOrBuy = scanner.next();

        if (sellOrBuy.equals("remove")) {
            shop.printProducts();
            System.out.println("Which product you want to remove?");
            String product = scanner.next();

            if (shop.sellProduct(product)) System.out.println("You deleted this product");
            else System.out.println("No such a product");
        } else if (sellOrBuy.equals("add")) {
            System.out.println("Which product you want to add?");
            String product = scanner.next();

            shop.addProduct(product);
            System.out.println("You successfully added this product to your assortment");
        } else {
            System.out.println("Please print correct query");
            removeOrAdd(scanner);
        }
    }

    private void addChat(Scanner scanner) throws FileNotFoundException {
        Server server = Server.getInstance();

        System.out.println("Print user login with who you want to chat");
        String login = scanner.next();

        if (server.checkLogin(login)) {
            ((HealthShop) shop).addChat(new Chat((User) server.getUser(login), (HealthShop) shop));
        } else {
            System.out.println("There's no users with this login");
            addChat(scanner);
        }
    }

    private void sendMessage(Scanner scanner) throws FileNotFoundException {
        ((HealthShop) shop).printChats();

        System.out.println("Print chat id you want to send message");
        int id = scanner.nextInt();

        System.out.println("Print word you want to send");
        String message = scanner.next();
        if (((HealthShop) shop).sendMessage(id, message)) {
            System.out.println("You successfully sent message");
        } else {
            sendMessage(scanner);
        }
    }

    private void sendOrAdd(Scanner scanner) throws FileNotFoundException {
        System.out.println("Do you want add new chat or send message to exist chat?(Print add/send)");
        String answerQuery = scanner.next();

        if (answerQuery.equals("add")) {
            addChat(scanner);
        } else if (answerQuery.equals("send")) {
            sendMessage(scanner);
        } else {
            System.out.println("Please, print correct query");
            sendOrAdd(scanner);
        }
    }

    public void startProcess(Scanner scanner) throws FileNotFoundException {
        if (shop instanceof HealthShop) {
            System.out.println("Do you manage you stock or send message?(Print stock/send)");
            String answerQuery = scanner.next();

            if (answerQuery.equals("stock")) {
                removeOrAdd(scanner);
            } else if (answerQuery.equals("send")) {
                sendOrAdd(scanner);
            } else {
                System.out.println("Please print correct query");
            }
        } else {
            removeOrAdd(scanner);
        }
    }
}
