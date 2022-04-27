public class FoodMethod extends FactoryMethod {
    @Override
    public AbstractShop createInstance(String login, String password) {
        return new FoodShop(login, password);
    }
}
