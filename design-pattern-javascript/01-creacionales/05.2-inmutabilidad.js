/**
 * ! Inmutabilidad con copia
 * Aunque la inmutabilidad es una buena práctica, no siempre es posible.
 * En estos casos, se puede hacer una copia del objeto y modificar la copia.
 *
 *  * Es útil para mantener un historial de estados en aplicaciones interactivas.
 *
 */

import chalk from "chalk";

/**
 1.	Completen el método copyWith en la clase Player para que permita 
 crear una copia con cambios en name, score o level.
 
 2.	Usen el código cliente para probar el funcionamiento de copyWith, 
 haciendo cambios en el puntaje, nivel y nombre del jugador.
 */

class Player {
	name;
	score;
	level;

	constructor({ level, name, score }) {
		this.name = name;
		this.score = score;
		this.level = level;
	}

	copyWith({ name, score, level }) {
		return new Player({
			name: name ?? this.name,
			score: score ?? this.score,
			level: level ?? this.level,
		});
	}

	displayState() {
		console.log(chalk.green(`Jugador: ${this.name}`));
		console.log(chalk.yellow(`Puntaje: ${this.score}`));
		console.log(chalk.blue(`Nivel: ${this.level}`));
	}
}

function main() {
	let player = new Player({ name: "Carlos", score: 0, level: 1 });
	console.log("Estado inicial:");
	player.displayState();

	// Incrementar el puntaje
	player = player.copyWith({ score: 10 });
	console.log("\nDespués de incrementar el puntaje:");
	player.displayState();

	// subir de nivel
	player = player.copyWith({ level: 2 });
	console.log("\nDespués de subir de nivel:");
	player.displayState();

	// Cambiar el nombre del jugador
	player = player.copyWith({ name: "Carlos Pro" });
	console.log("\nDespués de cambiar el nombre:");
	player.displayState();
}

main();
