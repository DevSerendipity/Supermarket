import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

    /*

        valuesByKeys as in teamsByCaptains. If you are going to include both key and value, this seems to read best.
         At a high level, you can read it as just teams�, so anything that's performed on it is being performed on
         teams.
          The byCaptains prefix reads as it should do: a less significant qualifier that follows the teams around to
          help
           someone understands the structure if they need to.
         */
public class SupermarketJava {

    private static final Map<String, Integer> priceByProducts = new HashMap<>();

    private static final List<ItemJava> ITEM_JAVAS = new ArrayList<>();

    public static Map<String, Integer> getPriceByProduct() {
        return priceByProducts;
    }

    public static List<ItemJava> getPriceByItem() {
        return ITEM_JAVAS;
    }

    static int getProductSum() {
        priceByProducts.entrySet().forEach(AppJava::printProducts);

        int sumOfAllDiscounts = getSumOfAllDiscounts();

        int sumOfAllPriceIncrease = getSumOfAllPriceIncrease();

        return priceByProducts.values().stream().reduce(0, Integer::sum) + sumOfAllDiscounts + sumOfAllPriceIncrease;
    }

    private static int getSumOfAllDiscounts() {
        int sumOfAllDiscounts = 0;

        sumOfAllDiscounts += getPriceByProduct().entrySet().stream().filter(priceByProduct -> AppJava.isProductOnDiscount())
                                                .map(AppJava::getDiscount).reduce(0, Integer::sum);
        System.out.println("PRODUCTS WITH DISCOUNT\n");
        priceByProducts.entrySet().stream().filter(priceByProduct -> AppJava.isProductOnDiscount()).forEach(
                AppJava::priceDiscountText);
        return sumOfAllDiscounts;
    }

    private static int getSumOfAllPriceIncrease() {
        int sumPriceIncrease = 0;
        sumPriceIncrease += getPriceByProduct().entrySet().stream().filter(
                priceByProduct -> AppJava.isProductPriceIncrease()).map(AppJava::getPriceIncrease).reduce(0, Integer::sum);

        System.out.println("PRODUCTS WITH PRICE INCREASE\n");
        priceByProducts.entrySet().stream().filter(priceByProduct -> AppJava.isProductPriceIncrease()).forEach(
                AppJava::priceIncreaseText);
        return sumPriceIncrease;
    }

    static void getShoppingCartItems() {
        try ( Stream<String> lines = Files.lines(
                Path.of(Objects.requireNonNull(SupermarketJava.class.getResource("/groceriesList.txt")).toURI())) ) {
            lines.map(ItemJava::new).forEach(ItemJava::addItem);
        } catch ( IOException | URISyntaxException e ) {
            System.out.println(e.getCause().getMessage());
        }
    }
}
