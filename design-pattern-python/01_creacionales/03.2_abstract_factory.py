from abc import ABC, abstractmethod

from rich.console import Console

console = Console()


class Vehicle(ABC):
    @abstractmethod
    def assemble(self) -> None:
        ...


class Engine(ABC):
    @abstractmethod
    def start(self) -> None:
        ...


class ElectricCar(Vehicle):
    def assemble(self) -> None:
        console.print('Ensamblando un auto [purple]eléctrico[/purple]')


class GasCar(Vehicle):
    def assemble(self) -> None:
        console.print('Ensamblando un auto de [gray30]combustion[/gray30]')


class ElectricEngine(Engine):
    def start(self) -> None:
        console.print('Arrancando motor [pink1]eléctrico[/pink1]')


class GasEngine(Engine):
    def start(self) -> None:
        console.print('Arrancando motor de [cyan]combustion[/cyan]')


class VehicleFactory(ABC):
    @abstractmethod
    def create_vehicle(self) -> Vehicle:
        ...

    @abstractmethod
    def create_engine(self) -> Engine:
        ...


class ElectricVehicleFactory(VehicleFactory):
    def create_vehicle(self) -> Vehicle:
        return ElectricCar()

    def create_engine(self) -> Engine:
        return ElectricEngine()


class GasVehicleFactory(VehicleFactory):
    def create_vehicle(self) -> Vehicle:
        return GasCar()

    def create_engine(self) -> Engine:
        return GasEngine()


def main(factory: VehicleFactory) -> None:
    vehicle = factory.create_vehicle()
    engine = factory.create_engine()

    vehicle.assemble()
    engine.start()


console.print('Creando vehículo eléctrico:')
main(ElectricVehicleFactory())

console.print('\nCreando vehículo de combustion:')
main(GasVehicleFactory())
