public class FoodShop extends AbstractShop {
    protected Food shopType;

    FoodShop(String login, String password, Food shopType) {
        super(login, password);
        this.shopType = shopType;
    }

    @Override
    public String getShopType() {
        return shopType.toString();
    }
}
