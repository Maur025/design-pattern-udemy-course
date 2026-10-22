from collections.abc import Callable
from typing import Literal

from rich.console import Console

console = Console()

type Language = Literal["es", "en", "fr"]


def create_greeter(lang: Language) -> Callable[[str], None]:
    def greeter(name: str) -> None:
        messages = {
            "es": f"Hola, [red]{name}[/red]",
            "en": f"Hello, [red]{name}[/red]",
            "fr": f"Bonjour, [red]{name}[/red]",
        }

        console.print(messages[lang])

    return greeter


def main():
    spanish_greeter = create_greeter("es")
    spanish_greeter("Mauro")

    english_greeter = create_greeter("en")
    english_greeter("Alice")

    french_greeter = create_greeter("fr")
    french_greeter("Pierre")


main()
