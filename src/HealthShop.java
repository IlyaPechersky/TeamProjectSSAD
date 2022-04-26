import java.util.ArrayList;
import java.util.List;

public class HealthShop extends AbstractShop implements ChatMember {
    private List<Chat> chatList;

    HealthShop(String login, String password) {
        super(login, password);
        chatList = new ArrayList<>();
    }

    @Override
    public String getShopType() {
        return "Herb";
    }

    @Override
    public boolean sendMessage(int chatId, String message) {
        if (chatId >= chatList.size()) {
            System.out.println("No such a chat...");
            return false;
        }
        chatList.get(chatId).sendNewMessage("Shop: " + message);
        return true;
    }

    @Override
    public void addChat(Chat chat) {
        chatList.add(chat);
    }
}
