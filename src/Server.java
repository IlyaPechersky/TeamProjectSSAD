import java.util.Map;

public class Server {
    private static Server instance;
    private static Map<String, String> usersDB;

    private Server() {
    }

    public static Server getInstance() {
        if (instance == null) instance = new Server();
        return instance;
    }
}
