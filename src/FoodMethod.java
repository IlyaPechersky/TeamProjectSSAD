public class FoodMethod implements FactoryMethod {
    @Override
    public AbstractShop createInstance(String login, String password) {
        return new FoodShop(login, password);
    }
}
