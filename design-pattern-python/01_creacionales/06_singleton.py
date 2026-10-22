from typing import ClassVar, Self

from rich.console import Console

console = Console()


class DragonBalls:
    _instance: ClassVar["Self | None"] = None
    __balls_collected: int

    def __init__(self) -> None:
        self.__balls_collected = 0

    @classmethod
    def get_instance(cls) -> Self:
        if cls._instance is None:
            cls._instance = cls()

        return cls._instance

    def collect_ball(self):
        if self.__balls_collected < 7:
            self.__balls_collected += 1
            console.print(
                f"Pelota recolectada. Total de esferas: {self.__balls_collected}"
            )
            return

        console.print(
            "Ya se han recolectado las 7 esferas del Dragón! Invoca a Shenlong"
        )

    def summon_shenlong(self):
        if self.__balls_collected == 7:
            console.print("Shenlong ha sido invocado, pide tu deseo!")
            self.__balls_collected = 0
            return

        console.print(
            f"Aún faltan {7 - self.__balls_collected} pelotas para invocar a Shenlong"
        )


def main():
    gokuDragonBalls = DragonBalls.get_instance()

    gokuDragonBalls.collect_ball()
    gokuDragonBalls.collect_ball()
    gokuDragonBalls.collect_ball()

    gokuDragonBalls.summon_shenlong()

    vegetaDragonBalls = DragonBalls.get_instance()

    vegetaDragonBalls.collect_ball()
    vegetaDragonBalls.collect_ball()
    vegetaDragonBalls.collect_ball()
    vegetaDragonBalls.collect_ball()

    gokuDragonBalls.summon_shenlong()

    vegetaDragonBalls.summon_shenlong()


main()
