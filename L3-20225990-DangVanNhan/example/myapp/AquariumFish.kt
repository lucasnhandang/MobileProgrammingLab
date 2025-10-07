package example.myapp

// Fish behavior
interface FishAction {
    fun eat()
}

// Fish color
interface FishColor {
    val color: String
}

// Singleton object for default gold color
object GoldColor : FishColor {
    override val color = "gold"
}

// Helper class for printing fish action
class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}

// Plecostomus fish with delegation
class Plecostomus(fishColor: FishColor = GoldColor) :
    FishAction by PrintingFishAction("eat algae"),
    FishColor by fishColor

// Shark fish
class Shark : FishAction, FishColor {
    override val color = "grey"
    override fun eat() {
        println("hunt and eat fish")
    }
}

// Test function
fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()

    println("Shark: ${shark.color}")
    shark.eat()

    println("Plecostomus: ${pleco.color}")
    pleco.eat()
}