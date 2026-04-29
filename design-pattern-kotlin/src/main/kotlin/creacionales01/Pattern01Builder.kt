package creacionales01

class Computer(
    var cpu: String = "cpu - not defined",
    var ram: String = "ram - not defined",
    var storage: String = "storage - not defined",
    var gpu: String? = null
) {
    fun displayConfiguration() {
        print(
            """Configuración de la computadora: 
            CPU: ${this.cpu}
            RAM: ${this.ram}
            Almacenamiento: ${this.storage}
            GPU: ${if (this.gpu != null) this.gpu else "Sin gpu"}
        """
        )
    }
}

class ComputerBuilder {
    val computer: Computer = Computer()

    fun setCpu(cpu: String): ComputerBuilder {
        computer.cpu = cpu
        return this
    }

    fun setRam(ram: String): ComputerBuilder {
        computer.ram = ram
        return this
    }

    fun setStorage(storage: String): ComputerBuilder {
        computer.storage = storage
        return this
    }

    fun setGpu(gpu: String): ComputerBuilder {
        computer.gpu = gpu
        return this
    }

    fun build(): Computer {
        return computer
    }
}

fun main() {
    val basicComputer: Computer =
        ComputerBuilder().setCpu("Intel Core 2 Duo").setRam("4GB").setStorage("256GB").build()

    println("Computadora básica: ")
    basicComputer.displayConfiguration()

    val gamerComputer: Computer =
        ComputerBuilder().setCpu("i7 14700k").setCpu("i9 14900k").setRam("128GB").setStorage("4TB")
            .setGpu("RTX 5090 Ti").build()

    println("Computadora gamer:")
    gamerComputer.displayConfiguration()
}