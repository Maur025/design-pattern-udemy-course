void main() {
  Computer basicComputer = ComputerBuilder()
      .setCpu('Intel Core 2 Duo')
      .setRam('4GB')
      .setStorage('256GB')
      .build();

  print('Computadora básica:');
  basicComputer.displayConfiguration();

  Computer gamerComputer = ComputerBuilder()
      .setCpu('i7 14700k')
      .setCpu('i9 14900k')
      .setRam('128GB')
      .setStorage('4TB')
      .setGpu('RTX 5090 Ti')
      .build();

  print('Computadora gamer:');
  gamerComputer.displayConfiguration();
}

class Computer {
  String cpu;
  String ram;
  String storage;
  String? gpu;

  Computer({
    this.cpu = 'cpu not defined',
    this.ram = 'ram - not defined',
    this.storage = 'storage - not defined',
    this.gpu,
  });

  void displayConfiguration() {
    print('''Configuración de la computadora:
    CPU: $cpu
    RAM: $ram
    Almacenamiento: $storage
    GPU: ${gpu ?? 'Sin gpu'}
    ''');
  }
}

class ComputerBuilder {
  Computer _computer;

  ComputerBuilder() : _computer = Computer();

  ComputerBuilder setCpu(String cpu) {
    _computer.cpu = cpu;
    return this;
  }

  ComputerBuilder setRam(String ram) {
    _computer.ram = ram;
    return this;
  }

  ComputerBuilder setStorage(String storage) {
    _computer.storage = storage;
    return this;
  }

  ComputerBuilder setGpu(String gpu) {
    _computer.gpu = gpu;
    return this;
  }

  Computer build() {
    return _computer;
  }
}
