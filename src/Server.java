import java.util.HashMap;
import java.util.Map;

public class Server {
    private static Server instance;
    private static Map<String, String> usersDB;

    private Server() {
        usersDB = new HashMap<>();
        usersDB.put("Guest", "#");
    }

    public static Server getInstance() {
        if (instance == null) {
            instance = new Server();
        }
        return instance;
    }

    public static boolean checkUser(String login, String password) {
        if (usersDB.containsKey(login)) {
            System.out.println("No such User: {" + login + "}");
            return false;
        }
        if (usersDB.get(login).equals(password)) {
            System.out.println("Correct");
            return true;
        }
        System.out.println("Password is incorrect");
        return false;
    }
}
