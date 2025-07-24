package org.example.classes;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.List;

public class MenuCreateCharacter {


    public static void menuCreateCharacters(Scanner scanner, List<Character> characters) {
        System.out.println("¡¡Crea Tu propio personaje!!");
        int option;
        while(true) {

            System.out.println("\nMenú principal");
            System.out.println("1. Crear personaje personalizado");
            System.out.println("2. Crear personaje aleatorio");
            System.out.println("3. Mostrar personajes creados");
            System.out.println("4. Vuelve al Menú principal");
            System.out.print("Elige una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (option) {
                case 1:
                    createCustomCharacter(scanner, characters);
                    break;
                case 2:
                    createRandomCharacter(scanner, characters);
                    break;
                case 3:
                    showAllCharacters(scanner, characters);
                    break;
                case 4:
                    System.out.println("Volvemos atrás!");
                    return;
                default:
                    System.out.println("❗ Opción no válida. Intenta de nuevo.");
            }

        }


    }

    // Métodos  de creacion.
    public static void createCustomCharacter(Scanner scanner, List<Character> characters) {
        System.out.print("Introduce el nombre de tu personaje: ");
        String name = scanner.nextLine();

        System.out.println("Elige la clase de tu personaje: ");
        System.out.println("1. Guerrero");
        System.out.println("2. Mago");
        System.out.println("¿Que clase eliges?: ");
        int classOption = Integer.parseInt(scanner.nextLine());  // a ver si podemos que se printe a continuación y no
        // debajo el IN
        scanner.nextLine();
        // Limpiar buffer

        if (classOption == 1) {
            // llamamos al constructor de 1 sola variable y le pasamos su parametro que lo hemos cogido del scaner en
            // linea 49
            Warrior warrior = new Warrior(name);
            // llamar a las funciones ramdom para rellenar el resto de parametros.
            warrior.setHp(warrior.getHp(),true);
            warrior.setStamina(warrior.getStamina());
            warrior.setStrength(warrior.getStrength());

            characters.add(warrior);
            System.out.println("✅ Guerrero creado: " + name);
        } else if (classOption == 2) {

            Wizard wizard = new Wizard(name);
            wizard.setHp(wizard.getHp(), true);
            wizard.setMana(wizard.getMana());
            wizard.setIntelligence(wizard.getIntelligence());
            characters.add(wizard);
            System.out.println("✅ Mago creado: " + name);
        } else {
            System.out.println("❌ Opción inválida. No se creó ningún personaje.");
        }
    }


// método de PJ randomizado

    public static void createRandomCharacter(Scanner scanner, List<Character> characters) {

        String[] nombres = { "Petronilo",
        "Eufrasio",
                "Aniceto",
                "Filogonio",
                "Ruperta",
                "Ciriaco",
                "Basilisa",
                "Tránsito",
                "Eustaquio",
                "Hermenegildo"};


        int i = new Random().nextInt(nombres.length);
        String nombreFeo = nombres[i];
        String name = nombreFeo + " "+ (characters.size() + 1);
        Random random = new Random();
        if (random.nextBoolean()) {
            Warrior warrior = new Warrior(name);
            warrior.setHp(warrior.getHp(),true);
            warrior.setStamina(warrior.getStamina());
            warrior.setStrength(warrior.getStrength());

            characters.add(warrior);
            System.out.println("🔀 Guerrero aleatorio creado: " + name);
        } else {
            Wizard wizard = new Wizard(name);
            wizard.setHp(wizard.getHp(),true);
            wizard.setMana(wizard.getMana());
            wizard.setIntelligence(wizard.getIntelligence());
            characters.add(wizard);
            System.out.println("🔀 Mago aleatorio creado: " + name);
        }
    }

    // Muestra todos los personajes de la lista de personajes
    public static void showAllCharacters(Scanner scanner, List<Character> characters) {
        if (characters.isEmpty()) {
            System.out.println("❗ No hay personajes creados aún.");
            return;
        }

        System.out.println("\n📋 Lista de personajes creados:");

        int counter = 0;
        for (Character personaje : characters) {   // por cada personaje en el array eb
            counter++;

            personaje.getInfo();
            System.out.print(counter);
            System.out.print(" - Info personaje " + personaje.getInfo());

            System.out.println("\n");
        }
    }
}

