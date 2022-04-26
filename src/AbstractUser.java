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

    public boolean signIn() {
        if (isAuthorized()) {
            System.out.println("You are already authorized...");
            return true;
        }
        authorized = server.checkUser(login, password);
        return true;
    }

    public boolean signUp() {
        return server.registerUser(login, password, this);
    }

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
