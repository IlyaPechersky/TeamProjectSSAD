public class User extends AbstractUser implements ChatMember {
    @Override
    boolean signIn() {
        return false;
    }

    @Override
    boolean signUp() {
        return false;
    }

    @Override
    public boolean sendMessage() {
        return false;
    }
}
