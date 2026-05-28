package org.design.pattern.creacionales.pattern03;

import org.design.pattern.util.ConsoleUtil;
import org.fusesource.jansi.Ansi.Color;

interface Vehicle {

    void assemble();
}

interface Engine {

    void start();
}

interface VehicleFactory {

    Vehicle createVehicle();

    Engine createEngine();
}

public class Pattern03AbstractFactory2 {

    static void main() {
        ConsoleUtil.initialize();

        ConsoleUtil.println("Creando vehiculo electrico:");
        execute(new ElectricVehicleFactory());

        ConsoleUtil.println("");

        ConsoleUtil.println("Creando vehiculo de combustion:");
        execute(new GasVehicleFactory());

        ConsoleUtil.clean();
    }

    static void execute(VehicleFactory factory) {
        Vehicle vehicle = factory.createVehicle();
        Engine engine = factory.createEngine();

        vehicle.assemble();
        engine.start();
    }
}

class ElectricCar implements Vehicle {

    @Override
    public void assemble() {
        ConsoleUtil.println("Ensamblando un auto electrico", Color.MAGENTA);
    }
}

class GasCar implements Vehicle {

    @Override
    public void assemble() {
        ConsoleUtil.println("Ensamblando un auto de combustion", Color.BLUE);
    }
}

class ElectricEngine implements Engine {

    @Override
    public void start() {
        ConsoleUtil.println("Arrancando motor electrico", Color.RED);
    }
}

class GasEngine implements Engine {

    @Override
    public void start() {
        ConsoleUtil.println("Arrancando motor de combustion", Color.CYAN);
    }
}

class ElectricVehicleFactory implements VehicleFactory {

    @Override
    public Vehicle createVehicle() {
        return new ElectricCar();
    }

    @Override
    public Engine createEngine() {
        return new ElectricEngine();
    }
}

class GasVehicleFactory implements VehicleFactory {

    @Override
    public Vehicle createVehicle() {
        return new GasCar();
    }

    @Override
    public Engine createEngine() {
        return new GasEngine();
    }
}