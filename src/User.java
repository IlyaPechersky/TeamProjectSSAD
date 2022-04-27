import java.util.ArrayList;
import java.util.List;

public class User extends AbstractUser implements ChatMember {
    private List<Chat> chatList;

    public User(String login, String password) {
        super(login, password);
        chatList = new ArrayList<>();
    }

    @Override
    public void printChats() {
        if (chatList.isEmpty()) {
            System.out.println("No chats there");
        }
        for (Chat chat : chatList) {
            chat.printChat(this);
        }
    }

    @Override
    public boolean sendMessage(int chatId, String message) {
        if (chatId >= chatList.size()) {
            System.out.println("No such a chat...");
            return false;
        }
        chatList.get(chatId).sendNewMessage("User: " + message);
        return true;
    }

    @Override
    public void addChat(Chat chat) {
        chatList.add(chat);
    }
}
