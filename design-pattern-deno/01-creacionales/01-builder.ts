import { COLORS } from "../helpers/colors.ts";
/**
 * ! Patrón Builder:
 * Es un patrón de diseño creacional que nos permite construir objetos complejos
 * paso a paso.
 *
 * El patrón nos permite producir distintos tipos y representaciones
 * de un objeto empleando el mismo código de construcción.
 *
 * * Es útil cuando necesitamos construir un objeto complejo con muchas partes
 * * y queremos que el proceso de construcción sea independiente de las partes
 * * que lo componen.
 *
 * https://refactoring.guru/es/design-patterns/builder
 */

class Computer {
	public cpu: string = "cpu - not defined";
	public ram: string = "ram - not defined";
	public storage: string = "storage - not defined";
	public gpu?: string;

	displayConfiguration() {
		console.log(`Configuración de la computadora
      CPU: ${this.cpu}
      RAM: ${this.ram}
      Almacenamiento: ${this.storage}
      GPU: ${this.gpu ?? "Sin gpu"}
      `);
	}
}

class ComputerBuilder {
	private readonly computer: Computer;

	constructor() {
		this.computer = new Computer();
	}

	setCpu(cpu: string): this {
		this.computer.cpu = cpu;
		return this;
	}

	setRam(ram: string): this {
		this.computer.ram = ram;
		return this;
	}

	setStorage(storage: string): this {
		this.computer.storage = storage;
		return this;
	}

	setGpu(gpu: string): this {
		this.computer.gpu = gpu;
		return this;
	}

	build(): Computer {
		return this.computer;
	}
}

function main() {
	const basicComputer: Computer = new ComputerBuilder()
		.setCpu("Intel Core 2 Duo")
		.setRam("4GB")
		.setStorage("256GB")
		.build();

	console.log("%cComputadora básica:", COLORS.blue);
	basicComputer.displayConfiguration();

	const gamerComputer: Computer = new ComputerBuilder()
		.setCpu("i7 14700k")
		.setCpu("i9 14900k")
		.setRam("128GB")
		.setStorage("4TB")
		.setGpu("RTX 5090 Ti")
		.build();

	console.log("%cComputadora gamer:", COLORS.red);
	gamerComputer.displayConfiguration();
}

main();
