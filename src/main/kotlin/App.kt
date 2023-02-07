fun main() {
    val app = App
    app.shoppingCartItems()
}

object App {


    fun shoppingCartItems() {
        Supermarket.shoppingCartItems
        println("""There are ${Supermarket.priceByProduct.size} items in the cart.
Which is a total of ${"$"}${Supermarket.productSum} dollars.""")

        println("\nItem total Discount: ${Supermarket.sumOfAllDiscounts}")
        println("\nItem total price increase: ${Supermarket.sumOfAllPriceIncrease}")
    }

    fun printProducts(shoppingCartElement: Map.Entry<String, Int>) {
        println(shoppingCartElement.key + ":" + shoppingCartElement.value)
    }

    fun priceIncreaseText(shoppingCartItem: Map.Entry<String, Int>) {
        println(shoppingCartItem.key + ":" + shoppingCartItem.value + " -> " + (shoppingCartItem.value * 1.1).toInt())
    }

    fun priceDiscountText(shoppingCartItem: Map.Entry<String, Int>) {
        println(shoppingCartItem.key + ":" + shoppingCartItem.value + " -> " + (shoppingCartItem.value * 0.7).toInt())
    }

    val isProductOnDiscount: Boolean
        get() = Math.random() < 0.1
    val isProductPriceIncrease: Boolean
        get() = Math.random() < 0.1

    fun getPriceIncrease(shoppingCartItem: Map.Entry<String, Int>): Int {
        return (shoppingCartItem.value * 1.1).toInt()
    }

    fun getDiscount(shoppingCartItem: Map.Entry<String, Int>): Int {
        return (shoppingCartItem.value * 0.7).toInt()
    }
}
