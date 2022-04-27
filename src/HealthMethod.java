public class HealthMethod implements FactoryMethod {
    @Override
    public AbstractShop createInstance(String login, String password) {
        return new HealthShop(login, password);
    }
}
