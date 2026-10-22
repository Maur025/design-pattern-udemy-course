from typing import ClassVar, Self

from rich.console import Console

console = Console()


class DatabaseConnection:
    _instance: ClassVar["Self | None"] = None
    __connected: bool = False

    # Método estático para obtener la instancia única
    @classmethod
    def get_instance(cls) -> Self:
        # Completar: implementar el patrón Singleton
        raise Exception("Method not implemented.")

    # Método para conectar a la base de datos
    def connect(self) -> None:
        # Completar: si no está conectado, mostrar mensaje de conexión
        pass

    # Método para desconectar de la base de datos
    def disconnect(self) -> None:
        # Completar: desconectar y mostrar mensaje de desconexión
        pass


# Pruebas
def main():
    db1 = DatabaseConnection.get_instance()
    db1.connect()  # Debería conectar a la base de datos

    db2 = DatabaseConnection.get_instance()
    db2.connect()  # Debería mostrar que ya existe una conexión activa

    console.print("Son iguales: ", db1 is db2)  # Debería mostrar true

    db1.disconnect()  # Debería cerrar la conexión

    db2.connect()  # Ahora debería conectar de nuevo, ya que se cerró la anterior


main()
