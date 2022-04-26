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

    public boolean checkUser(String login, String password) {
        if (loginToPasswordDB.containsKey(login)) {
            System.out.println("No such User: {" + login + "}");
            return false;
        }
        if (loginToPasswordDB.get(login).equals(password)) {
            System.out.println("Correct");
            return true;
        }
        System.out.println("Password is incorrect");
        return false;
    }

    public boolean registerUser(String login, String password, AbstractUser user) {
        if (loginToPasswordDB.containsKey(login)) {
            System.out.println("Such a login is already used, try another...");
            return false;
        }
        // todo add checker for correctness;
        loginToPasswordDB.put(login, password);
        loginToUserDB.put(login, user);
        return true;
    }
}
