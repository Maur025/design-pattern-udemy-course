package org.design.pattern.creacionales.pattern03;

import lombok.extern.slf4j.Slf4j;

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

@Slf4j
public class Pattern03AbstractFactory2 {

    static void main() {
        log.info("Creando vehiculo electrico:");
        execute(new ElectricVehicleFactory());

        log.info("-----------------------");

        log.info("Creando vehiculo de combustion:");
        execute(new GasVehicleFactory());
    }

    static void execute(VehicleFactory factory) {
        Vehicle vehicle = factory.createVehicle();
        Engine engine = factory.createEngine();

        vehicle.assemble();
        engine.start();
    }
}

@Slf4j
class ElectricCar implements Vehicle {

    @Override
    public void assemble() {
        log.info("Ensamblando un auto electrico");
    }
}

@Slf4j
class GasCar implements Vehicle {

    @Override
    public void assemble() {
        log.info("Ensamblando un auto de combustion");
    }
}

@Slf4j
class ElectricEngine implements Engine {

    @Override
    public void start() {
        log.info("Arrancando motor electrico");
    }
}

@Slf4j
class GasEngine implements Engine {

    @Override
    public void start() {
        log.info("Arrancando motor de combustion");
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