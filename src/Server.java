import java.util.HashMap;
import java.util.Map;

public class Server {
    private static Server instance;
    private static Map<String, String> loginToPasswordDB;
    private static Map<String, AbstractUser> loginToUserDB;

    private Server() {
        loginToPasswordDB = new HashMap<>();
        loginToUserDB = new HashMap<>();
    }

    public static Server getInstance() {
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

    public boolean registerUser(String login, String password, AbstractUser user) {
        if (loginToPasswordDB.containsKey(login)) {
            return false;
        }
        if (Checker.checkLogin(login) && Checker.checkPassword(password)) {
            loginToPasswordDB.put(login, password);
            loginToUserDB.put(login, user);
            return true;
        } else {
            System.out.println("You have incorrect login or password, please re-enter following these rules:");
            System.out.println("For login:\n" +
                    "1. Length of pass - more or equal than 4 characters\n" +
                    "2. Should contain at least 1 letter\n" +
                    "3. Only letter, digits and symbol \"_\"");
            System.out.println("For password:\n" +
                                "1. Length of pass - more or equal than 8 characters\n" +
                                "2. Should contain at least 1 capital letter, 1 lowercase letter and 1 digit\n" +
                                "3. Only letter, digits and symbol \"_\"");
            return false;
        }
    }

    public AbstractUser getUser(String login) {
        return loginToUserDB.getOrDefault(login, null);
    }
}
