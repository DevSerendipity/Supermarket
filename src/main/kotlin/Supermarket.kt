import java.io.File
import kotlin.random.Random

class Supermarket {

    companion object {
        val priceByProduct: MutableMap<String, Int> = hashMapOf()
        val productsWithDiscount: MutableMap<String, Int> = hashMapOf()
        val productsWitSpike: MutableMap<String, Int> = hashMapOf()
    }

    private val isProductGoingToBeOnDiscount: Boolean
        get() = Math.random() < 0.1

    private val isProductGoingToSpike: Boolean
        get() = Math.random() < 0.1

    val sumOfAllItems: Int
        get() = priceByProduct.values.sum()

    val sumOfDiscountItems: Int
        get() = productsWithDiscount.values.sum()

    val sumOfSpikeItems: Int
        get() = productsWitSpike.values.sum()

    val shoppingCartItems: Unit
        get() = loadAllProducts().forEach { handleProductPrices(it) }

    private fun handleProductPrices(productName: String) {
        val initialValue = Random.nextInt(1, 100)
        priceByProduct[productName] = initialValue
        if (isProductGoingToBeOnDiscount) {
            val discountValue = (initialValue * 0.7).toInt()
            productsWithDiscount[productName] = discountValue
        } else if (isProductGoingToSpike) {
            val spikeValue = (initialValue * 1.1).toInt()
            productsWitSpike[productName] = spikeValue
        }
    }

    private fun loadAllProducts(): List<String> = File("src/main/resources/groceriesList.txt").useLines { it.toList() }

}
