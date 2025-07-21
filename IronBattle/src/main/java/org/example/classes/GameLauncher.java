import org.example.classes.Wizard;
import org.example.classes.Warrior;
import org.example.classes.Character;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameLauncher {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        ArrayList<Character> characters = new ArrayList<>();

        System.out.println("¡¡Te damos la bienvenida a Ironhack Battle!!");

        int option;

        do {
            System.out.println("\nMenú principal");
            System.out.println("1. Crear personaje personalizado");
            System.out.println("2. Crear personaje aleatorio");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Introduce el nombre de tu personaje: ");
                    String namePj = scanner.nextLine();

                    System.out.println("Elige la clase de tu personaje: ");
                    System.out.println("1. Guerrero");
                    System.out.println("2. Mago");
                    int classOption = scanner.nextInt();
                    scanner.nextLine();

                    if (classOption == 1) {
                        Warrior warrior = new Warrior(namePj);
                        characters.add(warrior);
                        System.out.println("✅ Guerrero creado: " + namePj);
                    } else if (classOption == 2) {
                        Wizard wizard = new Wizard(namePj);
                        characters.add(wizard);
                        System.out.println("✅ Mago creado: " + namePj);
                    } else {
                        System.out.println("❌ Opción inválida. No se creó ningún personaje.");
                    }
                    break;

                case 2:
                    String randomName = "PJ" + (characters.size() + 1);
                    if (random.nextBoolean()) {
                        Warrior warrior = new Warrior(randomName);
                        characters.add(warrior);
                        System.out.println("🔀 Guerrero aleatorio creado: " + randomName);
                    } else {
                        Wizard wizard = new Wizard(randomName);
                        characters.add(wizard);
                        System.out.println("🔀 Mago aleatorio creado: " + randomName);
                    }
                    break;

                case 3:
                    System.out.println("¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }

        } while (option != 3);

        scanner.close();
    }
}
