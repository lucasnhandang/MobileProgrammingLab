package example.myapp

import java.lang.Math.PI

// Open class so it can be subclassed
open class Aquarium(
    open var length: Int = 100,
    open var width: Int = 20,
    open var height: Int = 40
) {

    // Volume property with getter and setter
    open var volume: Int
        get() = width * height * length / 1000  // in liters
        set(value) {
            height = (value * 1000) / (width * length)
        }

    // Shape of aquarium
    open val shape = "rectangle"

    // Water takes 90% of volume
    open var water: Double = 0.0
        get() = volume * 0.9

    // Initialization blocks
    init {
        println("aquarium initializing")
    }

    // Print dimensions and volume
    fun printSize() {
        println(shape)
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")
        println("Volume: $volume liters " +
                "Water: $water liters (${water / volume * 100.0}% full)")
    }

    // Secondary constructor: create aquarium by number of fish
    constructor(numberOfFish: Int) : this() {
        // 2000 cm^3 per fish * 1.1 for extra room
        val tank = numberOfFish * 2000 * 1.1
        height = (tank / (length * width)).toInt()
    }
}

// Subclass of Aquarium: cylinder tank
class TowerTank(override var height: Int, var diameter: Int) :
    Aquarium(height = height, width = diameter, length = diameter) {

    override var volume: Int
        // cylinder volume: π * r^2 * h
        get() = (width / 2 * length / 2 * height / 1000 * PI).toInt()
        set(value) {
            height = ((value * 1000 / PI) / (width / 2 * length / 2)).toInt()
        }

    // 80% filled with water
    override var water = volume * 0.8

    override val shape = "cylinder"
}
