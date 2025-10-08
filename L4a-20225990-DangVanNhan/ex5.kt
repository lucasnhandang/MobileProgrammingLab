interface DensityMeasurer {
    val density: Double
}

abstract class RockFormation(protected var volumeInCubicMeters: Double) {
    abstract val massInKg: Double

    open fun logData() {
        println("Mass: $massInKg kg, Volume: $volumeInCubicMeters m^3")
    }
}

class Basalt(volume: Double) : RockFormation(volume), DensityMeasurer {
    override val massInKg: Double = 500.0

    override val density: Double
        get() = massInKg / volumeInCubicMeters

    fun showDensity() {
        println("Density: $density kg/m^3")
    }
}

fun main() {
    val basalt = Basalt(0.25)
    basalt.logData()
    basalt.showDensity()
}
