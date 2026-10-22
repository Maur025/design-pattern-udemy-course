from typing import Self

from rich.console import Console

console = Console()


# 1.	Completen el método copy_with en la clase Player para que permita
# crear una copia con cambios en name, score o level.

# 2.	Usen el código cliente para probar el funcionamiento de copyWith,
# haciendo cambios en el puntaje, nivel y nombre del jugador.


# 1. Clase Player inmutable
class Player:
    name: str
    score: int
    level: int

    def __init__(self, name: str, score: int, level: int) -> None:
        raise Exception("Method not implemented")

    # Método copy_with para crear una copia modificada del jugador
    def copy_with(
        self,
        *,
        name: str | None = None,
        score: int | None = None,
        level: int | None = None,
    ) -> Self:
        raise Exception("Method not implemented")

    def display_state(self) -> None:
        console.print(f"[green]Jugador: {self.name}[/green]")
        console.print(f"[yellow]Puntaje: {self.score}[/yellow]")
        console.print(f"[blue]Nivel: {self.level}[/blue]")


# 2. Código Cliente para probar
def main():
    # Crear jugador inicial
    player = Player("Carlos", 0, 1)
    console.print("Estado inicial:")
    player.display_state()

    # Incrementar el puntaje
    player = player.copy_with(score=10)
    console.print("\nDespués de incrementar el puntaje:")
    player.display_state()

    # Subir de nivel
    player = player.copy_with(level=2)
    console.print("\nDespués de subir de nivel:")
    player.display_state()

    # Cambiar el nombre del jugador
    player = player.copy_with(name="Carlos Pro")
    console.print("\nDespués de cambiar el nombre:")
    player.display_state()


main()
