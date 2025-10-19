class Computer:
    cpu = "cpu - not defined"
    ram = "ram - not defined"
    storage = "storage - not defined"
    gpu: str | None = None

    def display_configuration(self):
        print(f"Configuration de la computadora\n"
              f"CPU: {self.cpu}\n"
              f"RAM: {self.ram}\n"
              f"Almacenamiento: {self.storage}\n"
              f"GPU: {"Sin gpu" if self.gpu is None else self.gpu}")


class ComputerBuilder:
    def __init__(self):
        self.computer = Computer()

    def set_cpu(self, cpu):
        self.computer.cpu = cpu
        return self

    def set_ram(self, ram):
        self.computer.ram = ram
        return self

    def set_storage(self, storage):
        self.computer.storage = storage
        return self

    def set_gpu(self, gpu):
        self.computer.gpu = gpu
        return self

    def build(self):
        return self.computer


def main():
    basic_computer = ComputerBuilder().set_cpu("Intel core 2 duo").set_ram("4GB").set_storage("256GB").build()

    print("Computadora básica:")
    basic_computer.display_configuration()

    gamer_computer = ComputerBuilder().set_cpu("i7 14700k").set_cpu("i9 14900k").set_ram("128GB").set_storage(
        "4TB").set_gpu("RTX 5090 ti").build()

    print("Computadora gamer:")
    gamer_computer.display_configuration()


main()
