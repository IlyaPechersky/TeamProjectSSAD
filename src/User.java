public class User extends AbstractUser implements ChatMember {
    @Override
    boolean signUp() {
        return false;
    }

    @Override
    public boolean sendMessage() {
        return false;
    }
}
