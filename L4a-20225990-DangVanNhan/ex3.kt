interface Sellable {
    fun sellPrice(): Double
}

abstract class Asset {
    abstract val valuation: Double
    fun printValuation() {
        println("Valuation: $valuation")
    }
}

class Car : Asset(), Sellable {
    override val valuation: Double = 25000.0
    override fun sellPrice(): Double = valuation
}

fun main() {
    val car = Car()
    car.printValuation()
    println("Sell Price: ${car.sellPrice()}")
}
