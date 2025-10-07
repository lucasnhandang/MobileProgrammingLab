package example.myapp
import example.myapp.decor.makeDecorations

fun buildAquarium() {
    val aquarium1 = Aquarium()
    aquarium1.printSize()

    val aquarium2 = Aquarium(width = 25)
    aquarium2.printSize()

    val aquarium3 = Aquarium(height = 35, length = 110)
    aquarium3.printSize()

    val aquarium4 = Aquarium(width = 25, height = 35, length = 110)
    aquarium4.printSize()

    val aquarium5 = Aquarium(numberOfFish = 29)
    aquarium5.printSize()

    aquarium5.volume = 70
    aquarium5.printSize()

    val tower = TowerTank(diameter = 25, height = 40)
    tower.printSize()
}

fun main() {
    buildAquarium()
    makeFish()
    makeDecorations()
}
