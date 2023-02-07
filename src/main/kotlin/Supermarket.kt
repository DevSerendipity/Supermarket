import java.io.IOException
import java.net.URISyntaxException
import java.nio.file.Files
import java.nio.file.Path
import java.util.*

/*

        valuesByKeys as in teamsByCaptains. If you are going to include both key and value, this seems to read best.
         At a high level, you can read it as just teams�, so anything that's performed on it is being performed on
         teams.
          The byCaptains prefix reads as it should do: a less significant qualifier that follows the teams around to
          help
           someone understands the structure if they need to.
         */
object Supermarket {
    val priceByProduct: MutableMap<String, Int> = hashMapOf()
    val productSum: Int
        get() {
            priceByProduct.entries.forEach(App::printProducts)
            return priceByProduct.values.fold(0, Int::plus)
        }
    val sumOfAllDiscounts: Int
        get() {
            var sumOfAllDiscounts = 0
            sumOfAllDiscounts += priceByProduct.entries.asSequence().filter { App.isProductOnDiscount }
                .map(App::getDiscount).fold(0, Int::plus)

            println("\nPRODUCTS WITH DISCOUNT\n")

            priceByProduct.entries.filter { App.isProductOnDiscount }.forEach(App::priceDiscountText)
            return sumOfAllDiscounts
        }
    val sumOfAllPriceIncrease: Int
        get() {
            var sumOfAllDiscounts = 0
            sumOfAllDiscounts += priceByProduct.entries.asSequence().filter { App.isProductPriceIncrease }
                .map(App::getPriceIncrease).fold(0, Int::plus)

            println("\nPRODUCTS WITH PRICE INCREASE\n")

            priceByProduct.entries.filter { App.isProductPriceIncrease }.forEach(App::priceIncreaseText)
            return sumOfAllDiscounts
        }
    val shoppingCartItems: Unit
        get() {
            try {
                Files.lines(
                    Path.of(Objects.requireNonNull(Supermarket.javaClass.getResource("/groceriesList.txt")).toURI()))
                    .use { lines ->
                        lines.map { Item(it) }.forEach(Item::addItem)
                    }
            } catch (e: IOException) {
                println(e.cause?.message)
            } catch (e: URISyntaxException) {
                println(e.cause?.message)
            }
        }
}

