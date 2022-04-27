public class HealthMethod extends FactoryMethod {
    @Override
    public AbstractShop createInstance(String login, String password) {
        return new HealthShop(login, password);
    }
}
