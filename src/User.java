public abstract class User {
    protected String login;
    protected String password;
    protected boolean authorized;

    abstract boolean signIn();
    abstract boolean signUp();
}
