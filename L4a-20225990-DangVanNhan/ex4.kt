interface Renderable {
    val id: String
    val color: String
    fun displayInfo()
}

abstract class GeometricShape(protected var internalId: Int) {
    abstract val area: Double
    abstract fun calculateVolume(): Double

    fun reportStatus() {
        println("Shape is active")
    }
}

open class Cube(
    private val sideLength: Double,
    override val color: String,
    initialId: Int
) : GeometricShape(initialId), Renderable {

    override val id: String = "CUBE_$initialId"
    override val area: Double
        get() = sideLength * sideLength

    override fun calculateVolume(): Double = sideLength * sideLength * sideLength

    override fun displayInfo() {
        println("Cube ID: $id | Color: $color | Internal ID: $internalId")
    }
}

class SpecializedCube(sideLength: Double, color: String, id: Int) :
    Cube(sideLength, color, id) {

    fun showInternalId() {
        println("Accessing protected internalId: $internalId")
    }
}

fun main() {
    val cube = Cube(3.0, "Red", 101)
    cube.displayInfo()
    cube.reportStatus()

    val specCube = SpecializedCube(4.0, "Blue", 202)
    specCube.showInternalId()
}
