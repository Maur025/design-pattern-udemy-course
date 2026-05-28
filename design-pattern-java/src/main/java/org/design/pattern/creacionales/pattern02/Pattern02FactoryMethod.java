package org.design.pattern.creacionales.pattern02;

import java.util.Scanner;
import org.design.pattern.util.ConsoleUtil;
import org.fusesource.jansi.Ansi.Color;

/**
 * ! Factory Method: El patrón Factory Method permite crear objetos sin especificar la clase exacta
 * del objeto que se creará.
 * <p>
 * En lugar de eso, delegamos la creación de objetos a subclases o métodos que encapsulan esta
 * lógica.
 * <p>
 * Es útil cuando una clase no puede anticipar la clase de objetos que debe crear.
 * <p>
 * <a href="https://refactoring.guru/es/design-patterns/factory-method">refactoring-guru</a>
 */

interface Hamburger {

    void prepare();
}

public class Pattern02FactoryMethod {

    static void main(String[] args) {
        ConsoleUtil.initialize();

        Scanner input = new Scanner(System.in);

        ConsoleUtil.println("¿Que tipo de hamburguesa quieres? (chicken / beef / bean)");
        String burgerType = input.next();

        Restaurant restaurant = switch (burgerType) {
            case "chicken" -> new ChickenRestaurant();
            case "beef" -> new BeefRestaurant();
            case "bean" -> new BeanRestaurant();
            default -> throw new IllegalArgumentException("Tipo de hamburguesa invalido");
        };

        restaurant.orderHamburger();

        ConsoleUtil.clean();
    }
}

class ChickenHamburger implements Hamburger {

    @Override
    public void prepare() {
        ConsoleUtil.println("Preparando una hamburguesa de pollo", Color.YELLOW);
    }
}

class BeefHamburger implements Hamburger {

    @Override
    public void prepare() {
        ConsoleUtil.println("Preparando una hamburguesa de res", Color.MAGENTA);
    }
}

class BeanHamburger implements Hamburger {

    @Override
    public void prepare() {
        ConsoleUtil.println("Preparando una hamburguesa de frijol", Color.GREEN);
    }
}

abstract class Restaurant {

    protected abstract Hamburger createHamburger();

    public void orderHamburger() {
        Hamburger hamburger = createHamburger();
        hamburger.prepare();
    }
}

class ChickenRestaurant extends Restaurant {

    @Override
    protected Hamburger createHamburger() {
        return new ChickenHamburger();
    }
}

class BeefRestaurant extends Restaurant {

    @Override
    protected Hamburger createHamburger() {
        return new BeefHamburger();
    }
}

class BeanRestaurant extends Restaurant {

    @Override
    protected Hamburger createHamburger() {
        return new BeanHamburger();
    }
}