package creacionales01

interface Hamburger {
    fun prepare()
}

class ChickenHamburger : Hamburger {
    override fun prepare() {
        println("Preparando una hamburguesa de pollo.")
    }
}

class BeefHamburger : Hamburger {
    override fun prepare() {
        println("Preparando una hamburguesa de res.")
    }
}

class BeanHamburger : Hamburger {
    override fun prepare() {
        println("Preparando una hamburguesa de frijol.")
    }
}

abstract class Restaurant {
    protected abstract fun createHamburger(): Hamburger

    fun orderHamburger() {
        val hamburger: Hamburger = createHamburger()
        hamburger.prepare()
    }
}

class ChickenRestaurant : Restaurant() {
    override fun createHamburger(): Hamburger {
        return ChickenHamburger()
    }
}

class BeefRestaurant : Restaurant() {
    override fun createHamburger(): Hamburger {
        return BeefHamburger()
    }
}

class BeanRestaurant : Restaurant() {
    override fun createHamburger(): Hamburger {
        return BeanHamburger()
    }
}

fun main() {
    println("¿Que tipo de hamburguesa quieres? (chicken / beef / bean)")
    val burgerType: String = readln()

    val restaurant: Restaurant = when (burgerType) {
        "chicken" -> ChickenRestaurant()
        "beef" -> BeefRestaurant()
        "bean" -> BeanRestaurant()
        else -> throw Error("opción no valida")
    }

    restaurant.orderHamburger()
}