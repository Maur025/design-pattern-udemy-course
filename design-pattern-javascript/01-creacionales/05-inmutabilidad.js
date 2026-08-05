/**
 * ! Inmutabilidad con copia
 * Aunque la inmutabilidad es una buena práctica, no siempre es posible.
 * En estos casos, se puede hacer una copia del objeto y modificar la copia.
 *
 *  * Es útil para mantener un historial de estados en aplicaciones interactivas.
 *
 */

import chalk from "chalk";

class CodeEditorState {
	content;
	cursorPosition;
	unsavedChanges;

	constructor(content, cursorPosition, unsavedChanges) {
		this.content = content;
		this.cursorPosition = cursorPosition;
		this.unsavedChanges = unsavedChanges;
	}

	copyWith({ content, cursorPosition, unsavedChanges }) {
		return new CodeEditorState(
			content ?? this.content,
			cursorPosition ?? this.cursorPosition,
			unsavedChanges ?? this.unsavedChanges,
		);
	}

	displayState() {
		console.log(`\n${chalk.green("Estado del editor:")}`);

		console.log(`
      Contenido: ${this.content}
      Cursor Pos: ${this.cursorPosition}
      Unsaved changes: ${this.unsavedChanges}
      `);
	}
}

class CodeEditorHistory {
	history = [];
	currentIndex = -1;

	save(state) {
		if (this.currentIndex < this.history.length - 1) {
			this.history = this.history.splice(0, this.currentIndex + 1);
		}

		this.history.push(state);
		this.currentIndex++;
	}

	undo() {
		if (this.currentIndex <= 0) {
			return null;
		}

		this.currentIndex--;
		return this.history[this.currentIndex];
	}

	redo() {
		if (this.currentIndex < this.history.length - 1) {
			this.currentIndex++;
			return this.history[this.currentIndex];
		}

		return null;
	}
}

function main() {
	const history = new CodeEditorHistory();

	let editorState = new CodeEditorState('console.log("Hola Mundo");', 2, false);

	history.save(editorState);

	console.log(chalk.blue("Estado inicial"));
	editorState.displayState();

	editorState = editorState.copyWith({
		content: 'console.log("Hola Mundo"); \nconsole.log("Nueva linea");',
		cursorPosition: 3,
		unsavedChanges: true,
	});

	history.save(editorState);

	console.log(chalk.blue("Después del primer cambio"));
	editorState.displayState();

	console.log(chalk.blue("Después de mover el cursor"));
	editorState = editorState.copyWith({ cursorPosition: 5 });

	history.save(editorState);
	editorState.displayState();

	console.log(chalk.blue("Después del undo"));
	editorState = history.undo();

	editorState.displayState();

	console.log(chalk.blue("Después del redo"));
	editorState = history.redo();

	editorState.displayState();
}

main();
