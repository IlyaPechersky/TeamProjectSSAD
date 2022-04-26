public abstract class AbstractShop extends AbstractUser {
    protected Food shopType;

    AbstractShop(String login, String password, Food shopType) {
        super(login, password);
        this.shopType = shopType;
    }
}
