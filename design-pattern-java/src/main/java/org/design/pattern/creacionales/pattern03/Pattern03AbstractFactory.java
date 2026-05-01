package org.design.pattern.creacionales.pattern03;

import lombok.extern.slf4j.Slf4j;

interface Hamburger {

    void prepare();
}

interface Drink {

    void pour();
}

interface RestaurantFactory {

    Hamburger createHamburger();

    Drink createDrink();
}

@Slf4j
public class Pattern03AbstractFactory {

    static void main(String[] args) {
        log.info("Pedido del menu regular:");
        execute(new FastFoodRestaurantFactory());

        log.info(" --- --- ---");

        log.info("Pedido del menu saludable:");
        execute(new HealthyRestaurantFactory());
    }

    static void execute(RestaurantFactory factory) {
        Hamburger hamburger = factory.createHamburger();
        Drink drink = factory.createDrink();

        hamburger.prepare();
        drink.pour();
    }
}

@Slf4j
class ChickenHamburger implements Hamburger {

    @Override
    public void prepare() {
        log.info("Preparando hamburguesa de Pollo.");
    }
}

@Slf4j
class BeefHamburger implements Hamburger {

    @Override
    public void prepare() {
        log.info("Preparando hamburguesa de Res.");
    }
}

@Slf4j
class Water implements Drink {

    @Override
    public void pour() {
        log.info("Sirviendo un vaso de agua");
    }
}

@Slf4j
class Soda implements Drink {

    @Override
    public void pour() {
        log.info("Sirviendo un vaso de gaseosa");
    }
}

class FastFoodRestaurantFactory implements RestaurantFactory {

    @Override
    public Hamburger createHamburger() {
        return new BeefHamburger();
    }

    @Override
    public Drink createDrink() {
        return new Soda();
    }
}

class HealthyRestaurantFactory implements RestaurantFactory {

    @Override
    public Hamburger createHamburger() {
        return new ChickenHamburger();
    }

    @Override
    public Drink createDrink() {
        return new Water();
    }
}