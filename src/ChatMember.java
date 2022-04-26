import java.util.ArrayList;
import java.util.List;

public interface ChatMember {
    boolean sendMessage(int chatId, String message);
    void addChat(Chat chat);
}
