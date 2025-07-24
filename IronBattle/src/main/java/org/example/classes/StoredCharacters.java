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


    public static void guardarPersonaje(Scanner scanner,List<Character> characters) {
// poner un try catch si eso.
        MenuCreateCharacter.showAllCharacters(scanner, characters);
        System.out.print("Elige el número del personaje a guardar: ");
        int personaje = scanner.nextInt();
        Character pj1 = characters.get(personaje -1);
        storeCharacter(pj1);
    }

    public static void storeCharacter( Character character) {
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
    }}