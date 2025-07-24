package org.example;

import org.example.classes.GameLauncher;

public class Main {
    public static void main(String[] args) {

        GameLauncher game = new GameLauncher();
        game.launch();

        // 1º Hacer la importación correctamente.
        // 2º Llamar al constructor correctamente. Antes new org.example.GameLauncher() -> Ahora GameLauncher();
    }
}