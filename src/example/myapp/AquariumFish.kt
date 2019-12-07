package example.myapp

abstract class AquariumFish: FishAction {
    abstract val color: String
    override fun eat() {println("yum")}
}

class Shark: AquariumFish(), FishAction, FishColor {
    override val color = "gray"
    override fun eat() {
        println("hunt and eat fish")
    }
}

class Plecostomus(fishiColor: FishColor = GoldColor):
    FishAction by PrintingFishAction("eat algae"),
    FishColor by fishiColor {
    override fun eat() {
        println("eat algae")
    }
}

interface FishAction  {
    fun eat()
}

interface FishColor {
    val color: String
}

object GoldColor: FishColor {
    override val color = "gold"
}

class PrintingFishAction(val food: String): FishAction {
    override fun eat() {
        println(food)
    }
}