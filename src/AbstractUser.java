import java.io.FileNotFoundException;

public abstract class AbstractUser {
    protected String login;
    protected String password;
    protected boolean authorized;
    protected Server server;

    AbstractUser(String login, String password) {
        this.login = login;
        this.password = password;
        authorized = false;
    }

    public boolean signIn() throws FileNotFoundException {
        server = Server.getInstance();
        if (isAuthorized()) {
            System.out.println("You are already authorized...");
            return true;
        }
        authorized = server.checkUser(login, password);
        return true;
    }

    public boolean signUp() throws FileNotFoundException {
        server = Server.getInstance();
        return server.registerUser(login, password, this);
    }

    @Override
    public String toString() {
        return login;
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
