package org.design.pattern.creacionales.pattern01;

import lombok.Getter;
import lombok.Setter;
import org.design.pattern.util.ConsoleUtil;
import org.fusesource.jansi.Ansi.Color;

/**
 * ! Patrón Builder: Es un patrón de diseño creacional que nos permite construir objetos complejos
 * paso a paso.
 * <p>
 * El patrón nos permite producir distintos tipos y representaciones de un objeto empleando el mismo
 * código de construcción.
 * <p>
 * Es útil cuando necesitamos construir un objeto complejo con muchas partes y queremos que el
 * proceso de construcción sea independiente de las partes que lo componen.
 */

public class Pattern01Builder {

    public static void main(String[] args) {
        ConsoleUtil.initialize();

        Computer basicComputer = new ComputerBuilder().setCpu("Intel core 2 duo")
            .setRam("4GB")
            .setStorage("256GB")
            .build();

        ConsoleUtil.println("Computadora básica:", Color.BLUE);
        basicComputer.displayConfiguration();

        Computer gamerComputer = new ComputerBuilder().setCpu("i7 14700k")
            .setCpu("i9 14900k")
            .setRam("128GB")
            .setStorage("4TB")
            .setGpu("RTX 5090 Ti")
            .build();

        ConsoleUtil.println("Computer gamer:", Color.RED);
        gamerComputer.displayConfiguration();

        ConsoleUtil.clean();
    }
}

@Getter
@Setter
class Computer {

    private String cpu;
    private String ram;
    private String storage;
    private String gpu;

    public void displayConfiguration() {
        String gpu = this.gpu != null ? this.gpu : "Sin GPU";

        ConsoleUtil.println(String.format(
            """
                Configuracion de la computadora:
                CPU: %s
                RAM: %s
                Almacenamiento: %s
                GPU: %s
                """, cpu, ram, storage, gpu
        ));
    }
}

class ComputerBuilder {

    private final Computer computer;

    public ComputerBuilder() {
        this.computer = new Computer();
    }

    public ComputerBuilder setCpu(String cpu) {
        computer.setCpu(cpu);
        return this;
    }

    public ComputerBuilder setRam(String ram) {
        computer.setRam(ram);
        return this;
    }

    public ComputerBuilder setStorage(String storage) {
        computer.setStorage(storage);
        return this;
    }

    public ComputerBuilder setGpu(String gpu) {
        computer.setGpu(gpu);
        return this;
    }

    public Computer build() {
        return computer;
    }
}
