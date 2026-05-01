/**
 * ! Abstract Factory:
 * Es un patrón de diseño que permite crear familias de objetos relacionados
 * sin especificar sus clases concretas.
 *
 * En lugar de crear objetos individuales directamente,
 * creamos fábricas que producen un conjunto de objetos relacionados.
 *
 * * Es útil cuando necesitas crear objetos que son parte de una familia
 * * y quieres asegurarte de que estos objetos se complementen entre sí.
 *
 * https://refactoring.guru/es/design-patterns/abstract-factory
 */

/**
 * !Instrucciones:
 	1.Completen las Clases de Productos:
    •	ElectricCar debe implementar Vehicle y mostrar el mensaje "Ensamblando un auto eléctrico".
    •	GasCar debe implementar Vehicle y mostrar el mensaje "Ensamblando un auto de combustión".
    •	ElectricEngine debe implementar Engine y mostrar el mensaje "Arrancando motor eléctrico".
    •	GasEngine debe implementar Engine y mostrar el mensaje "Arrancando motor de combustión".

	2.	Completen las Clases de Fábricas:
    •	ElectricVehicleFactory debe crear un ElectricCar y un ElectricEngine.
    •	GasVehicleFactory debe crear un GasCar y un GasEngine.

	3. Prueben el Código:
	  •	Ejecuten el código para asegurarse de que cada fábrica produce el tipo correcto de vehículo y motor.

 */

class ElectricCar {
	assemble() {
		console.log("Ensamblando un auto eléctrico");
	}
}

class GasCar {
	assemble() {
		console.log("Ensamblando un auto de combustión");
	}
}

class ElectricEngine {
	start() {
		console.log("Arrancando motor eléctrico");
	}
}

class GasEngine {
	start() {
		console.log("Arrancando motor de combustible");
	}
}

class ElectricVehicleFactory {
	createVehicle() {
		return new ElectricCar();
	}
	createEngine() {
		return new ElectricEngine();
	}
}

class GasVehicleFactory {
	createVehicle() {
		return new GasCar();
	}
	createEngine() {
		return new GasEngine();
	}
}

function main(factory) {
	const vehicle = factory.createVehicle();
	const engine = factory.createEngine();

	vehicle.assemble();
	engine.start();
}

console.log("Creando vehículo eléctrico:");
main(new ElectricVehicleFactory());

console.log("\nCreando vehículo de combustión:");
main(new GasVehicleFactory());
