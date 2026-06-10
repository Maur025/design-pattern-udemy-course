package org.design.pattern.creacionales.pattern05;

import lombok.Builder;
import org.design.pattern.util.ConsoleUtil;
import org.fusesource.jansi.Ansi.Color;

public class Pattern05Inmutabilidad2 {

    static void main() {
        ConsoleUtil.initialize();

        var player = new Player(PlayerProps.builder()
            .name("Carlos")
            .score(0)
            .level(1)
            .build());
        ConsoleUtil.println("Estado inicial:");
        player.displayState();

        // Incrementar puntaje
        player = player.copyWith(PlayerProps.builder()
            .score(10)
            .build());
        ConsoleUtil.println("\nDespues de incrementar el puntaje:");
        player.displayState();

        //Subir de nivel
        player = player.copyWith(PlayerProps.builder()
            .level(2)
            .build());
        ConsoleUtil.println("\nDespues de subir de nivel:");
        player.displayState();

        // Cambiar el nombre del jugador
        player = player.copyWith(PlayerProps.builder()
            .name("Carlos Pro")
            .build());
        ConsoleUtil.println("\nDespues de cambiar el nombre:");
        player.displayState();

        ConsoleUtil.clean();
    }
}

@Builder
record PlayerProps(String name, Integer score, Integer level) {

}

// should simplify by only record with builder and enable builderTo

record Player(String name, Integer score, Integer level) {

    public Player(PlayerProps playerProps) {
        this(playerProps.name(), playerProps.score(), playerProps.level());
    }

    public Player copyWith(PlayerProps playerProps) {
        return new Player(
            playerProps.name() != null ? playerProps.name() : this.name,
            playerProps.score() != null ? playerProps.score() : this.score,
            playerProps.level() != null ? playerProps.level() : this.level
        );
    }

    public void displayState() {
        ConsoleUtil.println("\nJugador: " + this.name, Color.GREEN);
        ConsoleUtil.println("Puntaje: " + this.score, Color.YELLOW);
        ConsoleUtil.println("Nivel: " + this.level, Color.BLUE);
    }
}