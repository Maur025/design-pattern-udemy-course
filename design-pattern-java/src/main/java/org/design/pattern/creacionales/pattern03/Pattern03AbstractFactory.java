package org.design.pattern.creacionales.pattern03;

import org.design.pattern.util.ConsoleUtil;
import org.fusesource.jansi.Ansi.Color;

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

public class Pattern03AbstractFactory {

    static void main(String[] args) {
        ConsoleUtil.initialize();

        ConsoleUtil.println("Pedido del menu regular:");
        execute(new FastFoodRestaurantFactory());

        ConsoleUtil.println("");

        ConsoleUtil.println("Pedido del menu saludable:");
        execute(new HealthyRestaurantFactory());

        ConsoleUtil.clean();
    }

    static void execute(RestaurantFactory factory) {
        Hamburger hamburger = factory.createHamburger();
        Drink drink = factory.createDrink();

        hamburger.prepare();
        drink.pour();
    }
}

class ChickenHamburger implements Hamburger {

    @Override
    public void prepare() {
        ConsoleUtil.println("Preparando hamburguesa de Pollo.", Color.YELLOW);
    }
}

class BeefHamburger implements Hamburger {

    @Override
    public void prepare() {
        ConsoleUtil.println("Preparando hamburguesa de Res.", Color.RED);
    }
}

class Water implements Drink {

    @Override
    public void pour() {
        ConsoleUtil.println("Sirviendo un vaso de agua", Color.CYAN);
    }
}

class Soda implements Drink {

    @Override
    public void pour() {
        ConsoleUtil.println("Sirviendo un vaso de gaseosa", Color.MAGENTA);
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