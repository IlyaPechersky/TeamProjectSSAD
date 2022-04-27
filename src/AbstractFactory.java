public abstract class AbstractFactory {
    abstract AbstractUser createInstance(String login, String password);
}
