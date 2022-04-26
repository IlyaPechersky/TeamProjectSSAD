public abstract class AbstractUser {
    protected String login;
    protected String password;
    protected boolean authorized;
    protected Server server;

    AbstractUser(String login, String password) {
        this.login = login;
        this.password = password;
    }

    AbstractUser() {
        this("Guest", "#");
    }

    {
        authorized = false;
        server = Server.getInstance();
    }

    abstract boolean signIn();
    abstract boolean signUp();

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAuthorized() {
        return authorized;
    }
}
