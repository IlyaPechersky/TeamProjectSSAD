import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Server {
    private static Server instance;
    private static Map<String, String> loginToPasswordDB;
    private static Map<String, AbstractUser> loginToUserDB;
    private static List<AbstractShop> shopList;
    private static Scanner scanner;
    private static PrintWriter writer;

    private Server() throws FileNotFoundException {
        loginToPasswordDB = new HashMap<>();
        loginToUserDB = new HashMap<>();
        shopList = new ArrayList<>();
        readDataBase();
    }

    private void readDataBase() throws FileNotFoundException {
        scanner = new Scanner(new File("database.txt"));
        while (scanner.hasNext()) {
            String type = scanner.next();
            String foodType = "";
            if (type.equals("FoodShop")) foodType = scanner.next();
            String login = scanner.next();
            String password = scanner.next();
            loginToPasswordDB.put(login, password);

            if (type.equals("User")) {
                loginToUserDB.put(login, new User(login, password));
            } else {
                boolean hasProducts = scanner.next().equals("true");

                if (type.equals("HealthShop")) {
                    loginToUserDB.put(login, new HealthShop(login, password));
                } else {
                    Food food = Food.VEGETABLE;
                    if (foodType.equals("GROCERY")) food = Food.GROCERY;
                    if (foodType.equals("FRUIT")) food = Food.FRUIT;
                    loginToUserDB.put(login, new FoodShop(login, password).setShopType(food));
                }


                AbstractShop shop = (AbstractShop) loginToUserDB.get(login);
                if (hasProducts) {
                    scanner.nextLine();
                    Arrays.stream(scanner.nextLine().split(" ")).forEach(shop::addProduct);
                }

                shopList.add(shop);
            }
        }
        scanner.close();
    }

    public void loadDataBase() throws FileNotFoundException {
        writer = new PrintWriter("database.txt");
        for (String login : loginToUserDB.keySet()) {
            if (loginToUserDB.get(login) instanceof User) {
                writer.write("User " + login + " " + loginToPasswordDB.get(login) + "\n");
            } else if (loginToUserDB.get(login) instanceof FoodShop) {
                FoodShop shop = (FoodShop) loginToUserDB.get(login);
                writer.write("FoodShop " + shop.getShopType() + " " + login + " " + loginToPasswordDB.get(login));
                if (shop.hasProducts()) writer.write(" true\n");
                else writer.write(" false\n");
                shop.printProducts(writer);
            } else {
                HealthShop shop = (HealthShop) loginToUserDB.get(login);
                writer.write("HealthShop " + login + " " + loginToPasswordDB.get(login));
                if (shop.hasProducts()) writer.write(" true\n");
                else writer.write(" false\n");
                shop.printProducts(writer);
            }
        }
        writer.close();
    }

    public static Server getInstance() throws FileNotFoundException {
        if (instance == null) {
            instance = new Server();
        }
        return instance;
    }

    public boolean checkLogin(String login) {
        return loginToPasswordDB.containsKey(login);
    }

    public boolean checkUser(String login, String password) {
        if (!loginToPasswordDB.containsKey(login)) {
            return false;
        }
        if (loginToPasswordDB.get(login).equals(password)) {
            return true;
        }
        return false;
    }

    public void printShopList() {
        //todo

    }

    public boolean registerUser(String login, String password, AbstractUser user) {
        if (loginToPasswordDB.containsKey(login)) {
            return false;
        }
        // todo add checker for correctness;
        loginToPasswordDB.put(login, password);
        loginToUserDB.put(login, user);
        return true;
    }

    public AbstractUser getUser(String login) {
        return loginToUserDB.getOrDefault(login, null);
    }
}
