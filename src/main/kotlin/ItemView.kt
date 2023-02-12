package newOne


class ItemView {

    fun displayAllProducts() {
        Supermarket.priceByProduct.forEach {
            println("Name: ${it.key} : Price = ${it.value}")
        }
    }

    fun displayProductsWithDiscounts() {
        Supermarket.productsWithDiscount.forEach {
            println("Name: ${it.key} : Price = ${it.value}")
        }
    }

    fun displayProductsWithSpikes() {
        Supermarket.productsWitSpike.forEach {
            println("Name: ${it.key} : Price = ${it.value}")
        }
    }

}
