import java.util.Map;

public class AppJava {

    public static void main(String[] args) {
        shoppingCartItems();
    }

    public static void shoppingCartItems() {
        SupermarketJava.getShoppingCartItems(); // retrieves shopping cart items and adds them to shopping cart
        System.out.println("There are " + SupermarketJava.getPriceByProduct().size() + " items in the cart.\nWhich is a total of $" + SupermarketJava.getProductSum() + " dollars."); // outputs the number of products
    }

    static void printProducts(Map.Entry<String, Integer> shoppingCartElement) {
        System.out.println(shoppingCartElement.getKey() + ":" + shoppingCartElement.getValue());
    }

    static void priceIncreaseText(Map.Entry<String, Integer> shoppingCartItem) {
        System.out.println(shoppingCartItem.getKey() + ":" + shoppingCartItem.getValue() + " -> "
                + (int) (shoppingCartItem.getValue() * 1.1));
    }

    static void priceDiscountText(Map.Entry<String, Integer> shoppingCartItem) {
        System.out.println(shoppingCartItem.getKey() + ":" + shoppingCartItem.getValue() + " -> "
                + (int) (shoppingCartItem.getValue() * 0.7));
    }

    static boolean isProductOnDiscount() {
        return Math.random() < 0.1;
    }

    static boolean isProductPriceIncrease() {
        return Math.random() < 0.1;
    }

    static int getPriceIncrease(Map.Entry<String, Integer> shoppingCartItem) {
        return (int) (shoppingCartItem.getValue() * 1.1);
    }

    static int getDiscount(Map.Entry<String, Integer> shoppingCartItem) {
        return (int) (shoppingCartItem.getValue() * 0.7);
    }
}
