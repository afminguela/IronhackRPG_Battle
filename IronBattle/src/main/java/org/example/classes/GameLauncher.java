package org.example;

import org.example.classes.Warrior;
import org.example.classes.Wizard;
import org.example.classes.Character;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameLauncher {
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();
    private final ArrayList<Character> characters = new ArrayList<>();

    public void launch() {
        System.out.println("¡¡Te damos la bienvenida a Ironhack Battle!!");

        int option;

        do {
            System.out.println("\nMenú principal");
            System.out.println("1. Crear personaje personalizado");
            System.out.println("2. Crear personaje aleatorio");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (option) {
                case 1 -> createCustomCharacter();
                case 2 -> createRandomCharacter();
                case 3 -> System.out.println("¡Hasta pronto!");
                default -> System.out.println("❗ Opción no válida. Intenta de nuevo.");
            }

        } while (option != 3);

        scanner.close();
    }

    private void createCustomCharacter() {
        System.out.print("Introduce el nombre de tu personaje: ");
        String name = scanner.nextLine();

        System.out.println("Elige la clase de tu personaje: ");
        System.out.println("1. Guerrero");
        System.out.println("2. Mago");
        int classOption = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        if (classOption == 1) {
            Warrior warrior = new Warrior(name);
            characters.add(warrior);
            System.out.println("✅ Guerrero creado: " + name);
        } else if (classOption == 2) {
            Wizard wizard = new Wizard(name);
            characters.add(wizard);
            System.out.println("✅ Mago creado: " + name);
        } else {
            System.out.println("❌ Opción inválida. No se creó ningún personaje.");
        }
    }

    private void createRandomCharacter() {
        String name = "PJ" + (characters.size() + 1);
        if (random.nextBoolean()) {
            Warrior warrior = new Warrior(name);
            characters.add(warrior);
            System.out.println("🔀 Guerrero aleatorio creado: " + name);
        } else {
            Wizard wizard = new Wizard(name);
            characters.add(wizard);
            System.out.println("🔀 Mago aleatorio creado: " + name);
        }
    }
}
