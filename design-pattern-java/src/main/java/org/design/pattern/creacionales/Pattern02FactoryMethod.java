package org.design.pattern.creacionales;

import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

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

@Slf4j
public class Pattern02FactoryMethod {

    static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        log.info("¿Que tipo de hamburguesa quieres? (chicken / beef / bean)");
        String burgerType = input.next();

        Restaurant restaurant = switch (burgerType) {
            case "chicken" -> new ChickenRestaurant();
            case "beef" -> new BeefRestaurant();
            case "bean" -> new BeanRestaurant();
            default -> throw new IllegalArgumentException("Tipo de hamburguesa invalido");
        };

        restaurant.orderHamburger();
    }
}

@Slf4j
class ChickenHamburger implements Hamburger {

    @Override
    public void prepare() {
        log.info("Preparando una hamburguesa de pollo");
    }
}

@Slf4j
class BeefHamburger implements Hamburger {

    @Override
    public void prepare() {
        log.info("Preparando una hamburguesa de res");
    }
}

@Slf4j
class BeanHamburger implements Hamburger {

    @Override
    public void prepare() {
        log.info("Preparando una hamburguesa de frijol");
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