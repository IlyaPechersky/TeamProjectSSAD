import java.util.Scanner;

public class Application {
    private static AbstractUser user;
    private static Scanner scanner;

    private static void login() {
        System.out.println("Print client if you are a client");
        System.out.println("Print shop if you are a shop");
        String userType = scanner.next();
        System.out.print("login: ");
        String login = scanner.next();
        System.out.println();
        System.out.println("password: ");
        String password = scanner.next();
        if (userType.equals("client")) {
            //todo
        } else {
            System.out.println("Are you a herbalist? (Yes/No)");
            String answer = scanner.next();
            if (answer.equals("Yes")) {
                //todo
            }
        }

    }

    private static void register() {

    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        System.out.println("Welcome to our console Shop!");
        System.out.println("Here some commands: \n" +
                "\t - log-in\n" +
                "\t - log-up\n");
        String command = scanner.next();
        if (command.equals("log-in")) {
            login();
        } else if (command.equals("log-up")) {
            register();
        }
    }
}
