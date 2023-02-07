import java.util.*

class Item(private val name: String) {

    private val price: Int
        get() {
            val maxProductPrice = 100
            return Random().nextInt(1, maxProductPrice)
        }

    fun addItem() {
        Supermarket.priceByProduct.putIfAbsent(name, price)
    }

}
