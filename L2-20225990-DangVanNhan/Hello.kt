// IT4785E - Lab 2
// Dang Van Nhan 20225990

import java.util.*    // required import

// Top-level list of decorations
val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

// Function to pick a random day of the week
fun randomDay(): String {
    val week = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

// Function returning fish food depending on the day using when-expression
fun fishFood(day: String): String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
}

// Compact helper functions
fun isTooHot(temperature: Int) = temperature > 30
fun isDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day == "Sunday"

// Function deciding whether water should be changed
fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

// Feed the fish with daily food and check water
fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}

// Swim function with default and named arguments
fun swim(speed: String = "fast") {
    println("swimming $speed")
}

// Function for higher-order operations
fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

// Example named function for higher-order usage
fun increaseDirty(start: Int) = start + 1

// Entry point
fun main(args: Array<String>) {
    // Will assign kotlin.Unit
    val isUnit = println("This is an expression")
    println(isUnit)

    val temperature = 10
    val isHot = if (temperature > 50) true else false
    println(isHot)

    val message = "The water temperature is ${ if (temperature > 50) "too warm" else "OK" }."
    println(message)

    // Call feedTheFish
    feedTheFish()

    // Demonstrate swim() calls
    swim()                  // uses default speed
    swim("slow")            // positional argument
    swim(speed = "turtle-like")  // named parameter

    // Demonstrate filters: eager vs lazy
    val eager = decorations.filter { it[0] == 'p' }
    println("eager: $eager")

    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: $filtered")

    val newList = filtered.toList()
    println("new list: $newList")

    // Demonstrate map with lazy evaluation
    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }

    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")

    val lazyMap2 = decorations.asSequence().filter { it[0] == 'p' }.map {
        println("access: $it")
        it
    }
    println("-----")
    println("filtered: ${lazyMap2.toList()}")

    // Demonstrate flatten()
    val mysports = listOf("basketball", "fishing", "running")
    val myplayers = listOf("LeBron James", "Ernest Hemingway", "Usain Bolt")
    val mycities = listOf("Los Angeles", "Chicago", "Jamaica")
    val mylist = listOf(mysports, myplayers, mycities)     // list of lists
    println("-----")
    println("Flat: ${mylist.flatten()}")

    // Demonstrate lambdas and higher-order functions
    var dirtyLevel = 20
    val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
    println(waterFilter(dirtyLevel))  // Lambda call

    println(updateDirty(30, waterFilter))       // Higher-order with lambda
    println(updateDirty(15, ::increaseDirty))   // Higher-order with named function

    dirtyLevel = 19
    dirtyLevel = updateDirty(dirtyLevel) { dirty -> dirty + 23 }
    println(dirtyLevel)
}
