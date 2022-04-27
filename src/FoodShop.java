public class FoodShop extends AbstractShop {
    protected Food shopType;

    FoodShop(String login, String password) {
        super(login, password);
    }

    public FoodShop setShopType(Food shopType) {
        this.shopType = shopType;
        return this;
    }

    @Override
    public String getShopType() {
        return shopType.toString();
    }
}
