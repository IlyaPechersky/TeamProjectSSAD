import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserInterface {
    private User user;

    UserInterface(User user) {
        this.user = user;
    }

    private void buyProduct(Scanner scanner) throws FileNotFoundException {
        Server server = Server.getInstance();
        server.printShopList();

        System.out.println("Print shop id you want to visit");
        int id = scanner.nextInt();

        AbstractShop shop = server.getShop(id);
        if (shop == null) buyProduct(scanner);

        shop.printProducts();
        System.out.println("Print product you want to buy");
        String product = scanner.next();

        if (shop.sellProduct(product)) System.out.println("Thanks for the purchase!");
        else System.out.println("No such a product");
    }

    private void addChat(Scanner scanner) throws FileNotFoundException {
        Server server = Server.getInstance();
        server.printShopList();

        System.out.println("Print shop id with who you want to chat");
        int id = scanner.nextInt();

        if (server.getShop(id) instanceof HealthShop) {
            user.addChat(new Chat(user, (HealthShop) server.getShop(id)));
        } else {
            System.out.println("You can not start a chat with this Shop");
            addChat(scanner);
        }
    }

    private void sendMessage(Scanner scanner) throws FileNotFoundException {
        user.printChats();

        System.out.println("Print chat id you want to send message");
        int id = scanner.nextInt();

        System.out.println("Print word you want to send");
        String message = scanner.next();
        if (user.sendMessage(id, message)) {
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
        }
    }

    public void startProcess(Scanner scanner) throws FileNotFoundException {
        System.out.println("Do you want to buy something or chat?(Print buy/chat)");
        String answerQuery = scanner.next();

        if (answerQuery.equals("buy")) {
            buyProduct(scanner);
        } else if (answerQuery.equals("chat")) {
            sendOrAdd(scanner);
        } else {
            System.out.println("Please, print correct query");
        }
    }
}
