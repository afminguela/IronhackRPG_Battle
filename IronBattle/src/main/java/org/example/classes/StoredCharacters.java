package org.example.classes;
import java.io.*;
import java.util.List;
import java.util.Scanner;
import org.example.classes.*;
public class StoredCharacters {

    private static final String FILE_NAME = "personaje.txt";

    // printo toda la lista
    // le pregunto por escanner que numero quiere guardar
    //ejecuto guardar personaje, linea a linea.
    // doy mensaje de OK


    public static void guardarPersonaje(Scanner scanner, List<Character> characters) {
// poner un try catch si eso.
        MenuCreateCharacter.showAllCharacters(scanner, characters);
        if (!characters.isEmpty()) {

            System.out.print("Elige el número del personaje a guardar: ");
            try {
                int personaje = scanner.nextInt();
                Character pj1 = characters.get(personaje - 1);
                storeCharacter(pj1);

            } catch (NumberFormatException e) {
                System.out.println("❗ Debes introducir un número válido.");
            } catch (Exception e) {
                System.out.println("❗ Ocurrió un error inesperado: " + e.getMessage());
            }
        }
    }

    public static void storeCharacter(Character character) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(character.getClass().getSimpleName());
            writer.newLine();
            writer.write(character.getName());
            writer.newLine();
            writer.write(String.valueOf(character.getHp()));
            writer.newLine();
            if (character instanceof Warrior) {
                Warrior warrior = (Warrior) character;
                writer.write(String.valueOf(warrior.getStamina()));
                writer.newLine();
                writer.write(String.valueOf(warrior.getStrength()));
                writer.newLine();

            } else if (character instanceof Wizard) {
                Wizard wizard = (Wizard) character;
                writer.write(String.valueOf(wizard.getIntelligence()));
                writer.newLine();
                writer.write(String.valueOf(wizard.getMana()));
                writer.newLine();
            }

            System.out.println("✅ Personaje guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo.");
        }
    }

    public static Character chargeCharacter(Scanner scanner, List<Character> characters) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String tipo = reader.readLine();
            String nombre = reader.readLine();
            int hp = Integer.parseInt(reader.readLine());


            Character personaje = null;

            if (tipo.equalsIgnoreCase("warrior")) {
                int stamina = Integer.parseInt(reader.readLine());
                int strength = Integer.parseInt(reader.readLine());
                Warrior warrior = new Warrior(nombre);
                warrior.setHp(hp, false);
                warrior.setStamina(stamina);
                warrior.setStrength(strength);
                personaje = warrior;
            } else if (tipo.equalsIgnoreCase("wizard")) {
                int intelligence = Integer.parseInt(reader.readLine());
                int mana = Integer.parseInt(reader.readLine());
                Wizard wizard = new Wizard(nombre);
                wizard.setHp(hp,false);
                wizard.setIntelligence(intelligence);
                wizard.setMana(mana);
                personaje = wizard;
            } else {
                System.out.println("Tipo de personaje desconocido.");
                return null;
            }


            characters.add(personaje);
            System.out.println("✅ Personaje cargado correctamente.");
            System.out.println( "✨✨ Has añadido Un "+ personaje.getClass().getSimpleName()+" Con " + personaje.getInfo() +
                    " ✨✨ " );
            return personaje;
        } catch (IOException | NumberFormatException e) {
            System.out.println("❌ Error al cargar el personaje: " + e.getMessage());
            return null;
        }
    }


}