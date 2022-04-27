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
        // todo add checker for correctness;
        loginToPasswordDB.put(login, password);
        loginToUserDB.put(login, user);
        return true;
    }

    public AbstractUser getUser(String login) {
        return loginToUserDB.getOrDefault(login, null);
    }
}
