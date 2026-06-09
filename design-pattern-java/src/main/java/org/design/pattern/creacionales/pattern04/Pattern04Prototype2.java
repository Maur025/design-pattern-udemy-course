package org.design.pattern.creacionales.pattern04;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.design.pattern.util.ConsoleUtil;

interface Prototype2<T> {

    T copy();
}

public class Pattern04Prototype2 {

    static void main() {
        ConsoleUtil.initialize();

        List<String> attacks = new ArrayList<>();
        attacks.add("Llamarada");
        attacks.add("Arañazo");

        Pokemon basePokemon = new Pokemon("Charmander", "Fuego", 1, attacks);

        Pokemon clone1 = basePokemon.copy();
        clone1.setName("Charmeleon");
        clone1.setLevel(16);
        clone1.getAttacks()
            .add("Lanzallamas");

        basePokemon.displayInfo();
        ConsoleUtil.println("");
        clone1.displayInfo();

        ConsoleUtil.clean();
    }
}


@Getter
@Setter
class Pokemon implements Prototype2<Pokemon> {

    public String name;
    public String type;
    public Integer level;
    public List<String> attacks;

    public Pokemon(String name, String type, Integer level, List<String> attacks) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.attacks = attacks;
    }

    public Pokemon(Pokemon pokemon) {
        this.name = pokemon.getName();
        this.type = pokemon.getType();
        this.level = pokemon.getLevel();
        this.attacks = new ArrayList<>(pokemon.getAttacks());
    }

    @Override
    public Pokemon copy() {
        return new Pokemon(this);
    }

    public void displayInfo() {
        ConsoleUtil.println(String.format(
            "Nombre: %s\nTipo: %s\nNivel: %s\nAtaques: %s", name, type, level,
            String.join(", ", attacks)
        ));
    }
}