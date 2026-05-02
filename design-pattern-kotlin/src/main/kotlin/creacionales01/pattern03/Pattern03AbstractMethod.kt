package creacionales01.pattern03

interface Hamburger {
    fun prepare()
}

interface Drink {
    fun pour()
}

class ChickenHamburger : Hamburger {
    override fun prepare() {
        println("Preparando hamburguesa de pollo")
    }
}

class BeefHamburger : Hamburger {
    override fun prepare() {
        println("Preparando hamburguesa de res")
    }
}

class Water : Drink {
    override fun pour() {
        println("Sirviendo un vaso de agua")
    }
}

class Soda : Drink {
    override fun pour() {
        println("Sirviendo un vaso de gaseosa")
    }
}

interface RestaurantFactory {
    fun createHamburger(): Hamburger
    fun createDrink(): Drink
}

class FastFoodRestaurantFactory : RestaurantFactory {
    override fun createHamburger(): Hamburger {
        return BeefHamburger()
    }

    override fun createDrink(): Drink {
        return Soda()
    }
}

class HealthyRestaurantFactory : RestaurantFactory {
    override fun createHamburger(): Hamburger {
        return ChickenHamburger()
    }

    override fun createDrink(): Drink {
        return Water()
    }
}

fun execute(factory: RestaurantFactory) {
    val hamburger: Hamburger = factory.createHamburger()
    val drink: Drink = factory.createDrink()

    hamburger.prepare()
    drink.pour()
}

fun main() {
    println("Pedido del menu regular:")
    execute(FastFoodRestaurantFactory())

    println()

    println("Pedido del menu saludable:")
    execute(HealthyRestaurantFactory())
}