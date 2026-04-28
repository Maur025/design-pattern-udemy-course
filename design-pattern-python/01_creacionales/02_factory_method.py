from abc import ABC, abstractmethod
from typing import Protocol


class Hamburger(Protocol):
    def prepare(self) -> None:
        ...


class ChickenHamburger:
    def prepare(self) -> None:
        print("Preparando una hamburguesa de pollo")


class BeefHamburger:
    def prepare(self) -> None:
        print("Preparando una hamburguesa de res")


class BeanHamburger:
    def prepare(self) -> None:
        print("Preparando una hamburguesa de frijol")


class Restaurant(ABC):
    @abstractmethod
    def create_hamburger(self) -> Hamburger:
        ...

    def order_hamburger(self) -> None:
        hamburger = self.create_hamburger()
        hamburger.prepare()


class ChickenRestaurant(Restaurant):
    def create_hamburger(self) -> Hamburger:
        return ChickenHamburger()


class BeefRestaurant(Restaurant):
    def create_hamburger(self) -> Hamburger:
        return BeefHamburger()


class BeanRestaurant(Restaurant):
    def create_hamburger(self) -> Hamburger:
        return BeanHamburger()


def main():
    restaurant = None

    burger_type = input("¿Que tipo de hamburguesa quieres? (chicken / beef / bean)\n")

    match burger_type.strip():
        case "chicken":
            restaurant = ChickenRestaurant()
        case "beef":
            restaurant = BeefRestaurant()
        case "bean":
            restaurant = BeanRestaurant()
        case _:
            raise Exception(f"El tipo {burger_type} no existe")

    if restaurant is None:
        raise Exception("No se encontró el restaurante")

    restaurant.order_hamburger()


main()
