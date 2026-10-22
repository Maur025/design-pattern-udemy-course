from datetime import datetime
from typing import Literal

from rich.console import Console

console = Console()


def format_date(date: datetime) -> str:
    return date.strftime("%Y-%m-%d %H:%M:%S")


type LogLevel = Literal["info", "warn", "error"]


def create_logger(level: LogLevel):
    raise Exception("Not implemented")


def main():
    info_logger = create_logger("info")
    warn_logger = create_logger("warn")
    error_logger = create_logger("error")

    info_logger("Aplicación iniciada correctamente.")
    warn_logger("El uso de memoria está alto.")
    error_logger("Error de conexión a la base de datos.")


main()
