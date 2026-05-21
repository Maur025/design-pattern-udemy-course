from typing import Protocol


class Hamburger(Protocol):
    def prepare(self) -> None:
        ...


class Drink(Protocol):
    def pour(self) -> None:
        ...


class ChickenHamburger:
    # noinspection PyMethodMayBeStatic
    def prepare(self) -> None:
        print('Preparando hamburguesa de Pollo')


class BeefHamburger:
    # noinspection PyMethodMayBeStatic
    def prepare(self) -> None:
        print('Preparando hamburguesa de Res')


class Water:
    # noinspection PyMethodMayBeStatic
    def pour(self) -> None:
        print('Sirviendo un vaso de agua')


class Soda:
    # noinspection PyMethodMayBeStatic
    def pour(self) -> None:
        print('Sirviendo un vaso de gaseosa')


class RestaurantFactory(Protocol):
    def create_hamburger(self) -> Hamburger:
        ...

    def create_drink(self) -> Drink:
        ...


class FastFoodRestaurantFactory:
    # noinspection PyMethodMayBeStatic
    def create_hamburger(self) -> Hamburger:
        return BeefHamburger()

    # noinspection PyMethodMayBeStatic
    def create_drink(self) -> Drink:
        return Soda()


class HealthyRestaurantFactory:
    # noinspection PyMethodMayBeStatic
    def create_hamburger(self) -> Hamburger:
        return ChickenHamburger()

    # noinspection PyMethodMayBeStatic
    def create_drink(self) -> Drink:
        return Water()


def main(factory: RestaurantFactory):
    hamburger: Hamburger = factory.create_hamburger()
    drink: Drink = factory.create_drink()

    hamburger.prepare()
    drink.pour()


print("\nPedido del menu regular:")
main(FastFoodRestaurantFactory())

print("\n\nPedido del menu saludable:")
main(HealthyRestaurantFactory())
