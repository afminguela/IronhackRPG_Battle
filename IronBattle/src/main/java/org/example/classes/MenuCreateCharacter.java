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

            System.out.println("\n       Menú principal");
            System.out.println("1. ✨ Crear personaje personalizado");
            System.out.println("2. 🔀 Crear personaje aleatorio");
            System.out.println("3. 📜 Mostrar personajes creados");
            System.out.println("4. 💾 Guarda tu  personajes favorito");
            System.out.println("5. ♻️ Carga tu personaje ya creado");
            System.out.println("6. ↩️ Vuelve al Menú principal");
            System.out.print("Elige una opción: ");
            try {
                option = scanner.nextInt();
                scanner.nextLine();

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
                        StoredCharacters.selectCharacterToStore(scanner, characters);
                        break;

                    case 5:
                        StoredCharacters.chargeCharacter(scanner, characters);
                        break;
                    case 6:
                        System.out.println(" ↩️ Volvemos atrás!");
                        return;
                    default:
                        System.out.println("❗ Opción no válida. Intenta de nuevo.");
                }

        } catch (NumberFormatException e){
            System.out.println("❗ Debes introducir un número válido.");
        } catch (Exception e) {
            System.out.println("❗ Ocurrió un error inesperado: " + e.getMessage());
        }
        }


    }

    // Métodos  de creacion.
    public static void createCustomCharacter(Scanner scanner, List<Character> characters) {
        System.out.print("Introduce el nombre de tu personaje: ");
        String name = scanner.nextLine();

        System.out.println("Elige la clase de tu personaje: ");
        System.out.println("1. ⚔️ Guerrero");
        System.out.println("2. 🔮️ Mago");
        System.out.println("¿Que clase eliges?: ");
        int classOption = Integer.parseInt(scanner.nextLine());
        scanner.nextLine();

        if (classOption == 1) {

            Warrior warrior = new Warrior(name);

            warrior.setHp(warrior.getHp(),true);
            warrior.setStamina(warrior.getStamina());
            warrior.setStrength(warrior.getStrength());

            characters.add(warrior);
            System.out.println("✅ ⚔️ Guerrero creado: " + name);
        } else if (classOption == 2) {

            Wizard wizard = new Wizard(name);
            wizard.setHp(wizard.getHp(), true);
            wizard.setMana(wizard.getMana());
            wizard.setIntelligence(wizard.getIntelligence());
            characters.add(wizard);
            System.out.println("✅ 🔮️ Mago creado: " + name);
        } else {
            System.out.println("❌ Opción inválida. No se creó ningún personaje.");
        }
    }




    public static void createRandomCharacter(Scanner scanner, List<Character> characters) {

        String[] names = { "Petronilo",
        "Eufrasio",
                "Aniceto",
                "Filogonio",
                "Ruperta",
                "Ciriaco",
                "Basilisa",
                "Tránsito",
                "Eustaquio",
                "Hermenegildo"};


        int i = new Random().nextInt(names.length);
        String uglyName = names[i];
        String name = uglyName + " "+ (characters.size() + 1);
        Random random = new Random();
        if (random.nextBoolean()) {
            Warrior warrior = new Warrior(name);
            warrior.setHp(warrior.getHp(),true);
            warrior.setStamina(warrior.getStamina());
            warrior.setStrength(warrior.getStrength());

            characters.add(warrior);
            System.out.println("\n 🔀 ⚔️ Guerrero aleatorio creado: " + name);
        } else {
            Wizard wizard = new Wizard(name);
            wizard.setHp(wizard.getHp(),true);
            wizard.setMana(wizard.getMana());
            wizard.setIntelligence(wizard.getIntelligence());
            characters.add(wizard);
            System.out.println(" \n 🔀 🔮️ Mago aleatorio creado: " + name);
        }
    }


    public static void showAllCharacters(Scanner scanner, List<Character> characters) {
        if (characters.isEmpty()) {
            System.out.println("❗ No hay personajes creados aún.");
            return;
        }

        System.out.println("\n  📋 Lista de personajes creados:");

        int counter = 0;
        for (Character character : characters) {
            counter++;

            character.getInfo();
            System.out.print(counter);
            System.out.print(" - Info personaje:  " + character.getInfo());

            System.out.println("\n");
        }
    }
}

