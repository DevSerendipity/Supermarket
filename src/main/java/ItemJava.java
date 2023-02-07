import java.util.Random;

public class ItemJava {
    private final String name;

    public ItemJava(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        int MAX_PRODUCT_PRICE = 100;
        return new Random().nextInt(1, MAX_PRODUCT_PRICE);
    }

    void addItem() {
        SupermarketJava.getPriceByProduct().putIfAbsent(getName(), getPrice());
    }
}
