package org.design.pattern;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Builder01 {

    public static void main(String[] args) {
        Computer basicComputer = new ComputerBuilder().setCpu("Intel core 2 duo")
            .setRam("4GB")
            .setStorage("256GB")
            .build();

        log.info("Computadora básica:");
        basicComputer.displayConfiguration();

        Computer gamerComputer = new ComputerBuilder().setCpu("i7 14700k")
            .setCpu("i9 14900k")
            .setRam("128GB")
            .setStorage("4TB")
            .setGpu("RTX 5090 Ti")
            .build();

        log.info("Computer gamer:");
        gamerComputer.displayConfiguration();
    }
}

@Slf4j
@Getter
@Setter
class Computer {

    private String cpu;
    private String ram;
    private String storage;
    private String gpu;

    public void displayConfiguration() {
        log.info(
            """
                Configuracion de la computadora:
                CPU: {}
                RAM: {}
                Almacenamiento: {}
                GPU: {}
                """, cpu, ram, storage, gpu != null ? gpu : "Sin GPU"
        );
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
