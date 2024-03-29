fun main() {
    val supermarketApplication = SupermarketApplication()
    supermarketApplication.start()
}

class SupermarketApplication {
    private val itemView = ItemView()
    private val supermarket = Supermarket()

    init {
        supermarket.shoppingCartItems
    }

    fun start() {

        println("LIST OF ALL PRODUCTS: ")
        itemView.displayAllProducts()
        println("Price for all items without price discount/spike is: ${supermarket.sumOfAllItems}")

        println("\nItems currently on discounts: ")
        itemView.displayProductsWithDiscounts()
        println("\nTotal discount value per all products: ${supermarket.sumOfDiscountItems}")

        println("\nItems currently on spike: ")
        itemView.displayProductsWithSpikes()
        println("Total spike value per all products: ${supermarket.sumOfSpikeItems}")
    }
}
