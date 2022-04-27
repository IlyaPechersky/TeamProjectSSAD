import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application {
    private static AbstractUser user;
    private static Scanner scanner;
    private static Server server;

    private static void signIn() throws FileNotFoundException {
        System.out.println("Please, write your login and password!");

        System.out.print("login: ");
        String login = scanner.next();
        System.out.print("password: ");
        String password = scanner.next();

        if (server.checkUser(login, password)) {
            user = server.getUser(login);
            System.out.println("Correct, welcome!");
        } else {
            System.out.println("No such login or incorrect password...\n" +
                    "Do you want to try again? (Yes\\No)");
            String answer = scanner.next();
            if (answer.equals("Yes")) signIn();
            else main(new String[]{});
        }
    }

    private static void signUp(String userType) throws FileNotFoundException {
        System.out.println("Please, write your login and password!");

        System.out.print("login: ");
        String login = scanner.next();
        System.out.print("password: ");
        String password = scanner.next();
        String shopType = "";
        Food food = Food.FRUIT;

        if (!userType.equals("client")) {
            System.out.println("Are you FOOD or HEALTH shop?");
            shopType = scanner.next();

            if (shopType.equals("FOOD")) {
                System.out.println("""
                        What type of food:\s
                        \t - grocery
                        \t - fruit
                        \t - vegetable
                        """);

                String foodType = scanner.next();
                if (foodType.equals("grocery")) food = Food.GROCERY;
                if (foodType.equals("fruit")) food = Food.FRUIT;
                if (foodType.equals("vegetable")) food = Food.VEGETABLE;
            }
        }

        if (server.checkLogin(login)) {
            System.out.println("Such login already exists.. \n" +
                    "Do you want to try again? (Yes\\No)");
            String answer = scanner.next();
            if (answer.equals("Yes")) signUp(userType);
            else main(new String[]{});
        }

        if (userType.equals("client")) {
            user = new User(login, password);
        } else if (shopType.equals("HEALTH")) {
            user = new HealthShop(login, password);
        } else {
            user = new FoodShop(login, password).setShopType(food);
        }

        System.out.println("You are registered");
    }

    public static void main(String[] args) throws FileNotFoundException {
        scanner = new Scanner(System.in);
        server = Server.getInstance();
        System.out.println("Welcome to our console Shop!");
        System.out.println("""
                Here some commands:\s
                \t - log-in
                \t - log-up
                """);
        String command = scanner.next();
        if (command.equals("log-in")) {
            signIn();
        } else if (command.equals("log-up")) {
            System.out.println("Are you a new client or a new shop?");
            String userType = scanner.next();
            signUp(userType);
        }

        if (user instanceof User) {
            UserInterface userInterface = new UserInterface((User) user);
            userInterface.startProcess(scanner);
        }

        if (user instanceof AbstractShop) {
            ShopInterface shopInterface = new ShopInterface((AbstractShop) user);
            shopInterface.startProcess(scanner);
        }

        server.loadDataBase();
    }
}
