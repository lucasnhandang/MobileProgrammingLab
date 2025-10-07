// Lab3_2.kt
// Demonstrates pairs/triples, collections, constants, and extension functions

// Demonstration for Companion Object is in Decoration.kt

// ========== Pairs and Triples ==========
fun demoPairsTriples() {
    // Create a pair using "to"
    val equipment = "fish net" to "catching fish"
    println("${equipment.first} used for ${equipment.second}")
    // Output: fish net used for catching fish

    // Create a Triple of 3 numbers
    val numbers = Triple(6, 9, 42)
    println(numbers.toString())   // (6, 9, 42)
    println(numbers.toList())     // [6, 9, 42]

    // A pair where the first element is also a pair
    val equipment2 = ("fish net" to "catching fish") to "equipment"
    println("${equipment2.first} is ${equipment2.second}")
    println("${equipment2.first.second}")
    // Output:
    // (fish net, catching fish) is equipment
    // catching fish

    // Destructuring a pair into variables
    val (tool, use) = equipment
    println("$tool is used for $use")

    // Destructuring a triple into variables
    val (n1, n2, n3) = numbers
    println("$n1 $n2 $n3")
}


// ========== Collections ==========
fun demoCollections() {
    // Example: list of numbers
    val list = listOf(1, 5, 3, 4)
    println(list.sum())  // 13

    // Example: list of strings
    val list2 = listOf("a", "bbb", "cc")
    // println(list2.sum())  // ERROR: can't sum strings

    // Sum lengths of strings using sumBy()
    println(list2.sumBy { it.length })  // 6

    // Iterate with listIterator()
    for (s in list2.listIterator()) {
        println("$s ")
    }
}


// ========== HashMap ==========
fun demoHashMap() {
    // Create a hash map of fish common names -> scientific names
    val scientific = hashMapOf(
        "guppy" to "poecilia reticulata",
        "catfish" to "corydoras",
        "zebra fish" to "danio rerio"
    )

    // Retrieve values by key
    println(scientific.get("guppy"))       // poecilia reticulata
    println(scientific["zebra fish"])      // danio rerio
    println(scientific.get("swordtail"))   // null

    // Provide a default if key not found
    println(scientific.getOrDefault("swordtail", "sorry, I don't know"))

    // Provide custom behavior if key not found
    println(scientific.getOrElse("swordtail") { "sorry, I don't know" })
}


// ========== Constants ==========
const val rocks = 3   // top-level constant

fun complexFunctionCall(): Int = 42

object Constants {
    // Constant inside an object
    const val CONSTANT2 = "object constant"
}

class MyClass {
    companion object {
        // Constant inside a companion object
        const val CONSTANT3 = "constant in companion"
    }
}

fun demoConstants() {
    // val can hold values from function calls
    val value1 = complexFunctionCall()
    println(value1)

    // Access constant from object
    println(Constants.CONSTANT2)

    // Access constant from companion object
    println(MyClass.CONSTANT3)
}


// ========== Extension Functions ==========

// Extension function for String: check if it has spaces
fun String.hasSpaces(): Boolean = indexOf(" ") != -1

// Simplified version (single-expression function)
fun String.hasSpaces2() = indexOf(" ") != -1

// Simple class with private property
class AquariumPlant(val color: String, private val size: Int)

// Extension function accessing public property
fun AquariumPlant.isRed() = color == "red"
// fun AquariumPlant.isBig() = size > 50  // ERROR: can't access private property

// Demonstrating type resolution for extensions
open class AquariumPlant2(val color: String, private val size: Int)
class GreenLeafyPlant(size: Int) : AquariumPlant2("green", size)

fun AquariumPlant2.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

// Extension property for AquariumPlant
val AquariumPlant.isGreen: Boolean
    get() = color == "green"

// Extension function with nullable receiver
fun AquariumPlant?.pull() {
    this?.apply { println("removing $this") }
}

fun demoExtensions() {
    println("Hello World".hasSpaces())   // true
    println("HelloWorld".hasSpaces2())   // false

    // Demonstrating extension resolution
    val plant = GreenLeafyPlant(10)
    plant.print()                        // GreenLeafyPlant
    val aquariumPlant: AquariumPlant2 = plant
    aquariumPlant.print()                // AquariumPlant

    // Using extension property
    val aquariumPlant2 = AquariumPlant("green", 10)
    println(aquariumPlant2.isGreen)      // true

    // Nullable extension function
    val nullablePlant: AquariumPlant? = null
    nullablePlant.pull()                 // no output
}


// ========== Main Driver ==========
fun main() {
    demoPairsTriples()
    demoCollections()
    demoHashMap()
    demoConstants()
    demoExtensions()
}
