import java.util.ArrayList;
import java.util.List;

public interface ChatMember {
    void printChats();
    boolean sendMessage(int chatId, String message);
    void addChat(Chat chat);
}
