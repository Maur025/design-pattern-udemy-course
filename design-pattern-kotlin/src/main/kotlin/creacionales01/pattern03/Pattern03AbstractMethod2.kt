package creacionales01.pattern03

interface Vehicle {
    fun assemble()
}

interface Engine {
    fun start()
}

class ElectricCar : Vehicle {
    override fun assemble() {
        println("Ensamblando un auto electrico")
    }
}

class GasCar : Vehicle {
    override fun assemble() {
        println("Ensamblando un auto de combustion")
    }
}

class ElectricEngine : Engine {
    override fun start() {
        println("Arrancando motor electrico")
    }
}

class GasEngine : Engine {
    override fun start() {
        println("Arrancando motor de combustion")
    }
}

interface VehicleFactory {
    fun createVehicle(): Vehicle
    fun createEngine(): Engine
}

class ElectricVehicleFactory : VehicleFactory {
    override fun createVehicle(): Vehicle {
        return ElectricCar()
    }

    override fun createEngine(): Engine {
        return ElectricEngine()
    }
}

class GasVehicleFactory : VehicleFactory {
    override fun createVehicle(): Vehicle {
        return GasCar()
    }

    override fun createEngine(): Engine {
        return GasEngine()
    }
}

fun execute(factory: VehicleFactory) {
    val vehicle: Vehicle = factory.createVehicle()
    val engine: Engine = factory.createEngine()

    vehicle.assemble()
    engine.start()
}

fun main() {
    println("Creando vehiculo electrico:")
    execute(ElectricVehicleFactory())

    println()

    println("Creando vehiculo de combustion:")
    execute(GasVehicleFactory())
}