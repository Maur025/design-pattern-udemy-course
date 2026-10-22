from typing import Self

from rich.console import Console

console = Console()


class CodeEditorState:
    content: str
    cursor_position: int
    unsaved_changes: bool

    def __init__(self, content: str, cursor_position: int, unsaved_changes) -> None:
        self.content = content
        self.cursor_position = cursor_position
        self.unsaved_changes = unsaved_changes

    def copy_with(
        self,
        *,
        content: str | None = None,
        cursor_position: int | None = None,
        unsaved_changes: bool | None = None,
    ) -> Self:

        return type(self)(
            content=self.content if content is None else content,
            cursor_position=(
                self.cursor_position if cursor_position is None else cursor_position
            ),
            unsaved_changes=(
                self.unsaved_changes if unsaved_changes is None else unsaved_changes
            ),
        )

    def display_state(self) -> None:
        console.print("\n[green]Estado del editor:[/green]")

        console.print(f"""
Contenido: {self.content}
Cursor Pos: {self.cursor_position}
Unsaved changes: {self.unsaved_changes}
        """)


class CodeEditorHistory:
    __history: list[CodeEditorState]
    __current_index: int

    def __init__(self) -> None:
        self.__history = []
        self.__current_index = -1

    def save(self, state: CodeEditorState) -> None:
        if self.__current_index < (len(self.__history) - 1):
            self.__history = self.__history[: self.__current_index + 1]

        self.__history.append(state)
        self.__current_index += 1

    def undo(self) -> CodeEditorState | None:
        if self.__current_index <= 0:
            return None

        self.__current_index -= 1
        return self.__history[self.__current_index]

    def redo(self) -> CodeEditorState | None:
        if self.__current_index < len(self.__history) - 1:
            self.__current_index += 1
            return self.__history[self.__current_index]

        return None


def main():
    history = CodeEditorHistory()

    editor_state = CodeEditorState('console.log("Hola Mundo");', 2, False)

    history.save(editor_state)

    console.print("[blue]Estado inicial[/blue]")
    editor_state.display_state()

    editor_state = editor_state.copy_with(
        content='console.log("Hola Mundo"); \nconsole.log("Nueva linea");',
        cursor_position=3,
        unsaved_changes=True,
    )

    history.save(editor_state)

    console.print("[blue]Después del primer cambio[/blue]")
    editor_state.display_state()

    console.print("[blue]Después de mover el cursor[/blue]")
    editor_state = editor_state.copy_with(cursor_position=5)

    history.save(editor_state)
    editor_state.display_state()

    console.print("[blue]Después del undo[/blue]")
    editor_state = history.undo()

    if editor_state is not None:
        editor_state.display_state()

    console.print("[blue]Después del redo[/blue]")
    editor_state = history.redo()

    if editor_state is not None:
        editor_state.display_state()


main()
