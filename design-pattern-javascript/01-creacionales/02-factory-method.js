/**
 * ! Factory Method:
 * El patrón Factory Method permite crear objetos sin especificar
 * la clase exacta del objeto que se creará.
 *
 * En lugar de eso, delegamos la creación de objetos a subclases o métodos
 * que encapsulan esta lógica.
 *
 * * Es útil cuando una clase no puede anticipar la clase
 * * de objetos que debe crear.
 *
 * https://refactoring.guru/es/design-patterns/factory-method
 *
 */
import * as readline from "node:readline/promises";
import { stdin as input, stdout as output } from "node:process";

class ChickenHamburger {
	prepare() {
		console.log("Preparando una hamburguesa de pollo.");
	}
}

class BeefHamburger {
	prepare() {
		console.log("Preparando una hamburguesa de res.");
	}
}

class BeanHamburger {
	prepare() {
		console.log("Preparando una hamburguesa de frijol.");
	}
}

class Restaurant {
	createHamburger() {}

	orderHamburger() {
		const hamburger = this.createHamburger();
		hamburger.prepare();
	}
}

class ChickenRestaurant extends Restaurant {
	createHamburger() {
		return new ChickenHamburger();
	}
}

class BeefRestaurant extends Restaurant {
	createHamburger() {
		return new BeefHamburger();
	}
}

class BeanRestaurant extends Restaurant {
	createHamburger() {
		return new BeanHamburger();
	}
}

async function main() {
	const rline = readline.createInterface({ input, output });

	let restaurant;

	const burgerType = await rline.question(
		"¿Que tipo de hamburguesa quieres? (chicken / beef / bean)",
	);

	rline.close();

	switch (burgerType) {
		case "chicken": {
			restaurant = new ChickenRestaurant();
			break;
		}
		case "beef": {
			restaurant = new BeefRestaurant();
			break;
		}
		case "bean": {
			restaurant = new BeanRestaurant();
			break;
		}
		default: {
			throw new Error("opción no valida");
		}
	}

	restaurant.orderHamburger();
}

main();
