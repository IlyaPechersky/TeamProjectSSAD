public abstract class AbstractShop extends AbstractUser {
    AbstractShop(String login, String password) {
        super(login, password);
    }

    abstract String getShopType();
}
