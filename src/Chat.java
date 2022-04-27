import java.util.ArrayList;
import java.util.List;

public class Chat {
    private final User user;
    private HealthShop healthShop;
    public List<String> messages;

    public Chat(User user, HealthShop healthShop) {
        this.user = user;
        this.healthShop = healthShop;
        messages = new ArrayList<>();
    }

    public boolean sendNewMessage(String message) {
        messages.add(message);
        return true;
    }

    public void printChat(AbstractUser sender) {
        if (sender instanceof User) {
            System.out.print(healthShop + " ");
        } else {
            System.out.print(user + " ");
        }
    }
}
