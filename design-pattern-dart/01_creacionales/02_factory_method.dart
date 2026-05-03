import 'dart:io';

void main() {
  stdout.write('¿Que tipo de hamburguesa quieres? (chicken / beef / bean)\n');
  final String? burgerType = stdin.readLineSync();

  final Restaurant restaurant = switch (burgerType) {
    'chicken' => ChickenRestaurant(),
    'beef' => BeefRestaurant(),
    'bean' => BeanRestaurant(),
    _ => throw ArgumentError("opción no valida"),
  };

  restaurant.orderHamburger();
}

abstract class Hamburger {
  void prepare();
}

class ChickenHamburger implements Hamburger {
  @override
  void prepare() {
    print("Preparando una hamburguesa de pollo");
  }
}

class BeefHamburger implements Hamburger {
  @override
  void prepare() {
    print("Preparando una hamburguesa de res");
  }
}

class BeanHamburger implements Hamburger {
  @override
  void prepare() {
    print("Preparando una hamburguesa de frijol");
  }
}

abstract class Restaurant {
  Hamburger createHamburger();

  void orderHamburger() {
    final Hamburger hamburger = createHamburger();
    hamburger.prepare();
  }
}

class ChickenRestaurant extends Restaurant {
  @override
  Hamburger createHamburger() {
    return ChickenHamburger();
  }
}

class BeefRestaurant extends Restaurant {
  @override
  Hamburger createHamburger() {
    return BeefHamburger();
  }
}

class BeanRestaurant extends Restaurant {
  @override
  Hamburger createHamburger() {
    return BeanHamburger();
  }
}
