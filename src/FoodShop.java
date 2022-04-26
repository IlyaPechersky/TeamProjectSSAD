public class FoodShop extends AbstractShop {
    FoodShop(String login, String password, Food shopType) {
        super(login, password, shopType);
    }

    @Override
    boolean signUp() {
        return false;
    }
}
