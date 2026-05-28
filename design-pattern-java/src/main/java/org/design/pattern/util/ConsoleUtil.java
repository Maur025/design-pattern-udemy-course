package org.design.pattern.util;

import static org.fusesource.jansi.Ansi.ansi;

import org.fusesource.jansi.Ansi.Color;
import org.fusesource.jansi.AnsiConsole;

public final class ConsoleUtil {

    private ConsoleUtil() {
    }

    public static void initialize() {
        System.setProperty("jansi.passthrough", "true");
        AnsiConsole.systemInstall();
    }

    public static void clean() {
        AnsiConsole.systemUninstall();
        System.clearProperty("jansi.passthrough");
    }

    public static void print(String text, Color color) {
        System.out.print(ansi().fg(color)
            .a(text)
            .reset());
    }

    public static void print(String text) {
        System.out.print(text);
    }

    public static void println(String text, Color color) {
        System.out.println(ansi().fg(color)
            .a(text)
            .reset());
    }

    public static void println(String text) {
        System.out.println(text);
    }
}
