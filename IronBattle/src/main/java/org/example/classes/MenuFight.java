package org.example.classes;

import java.util.Scanner;

public class MenuFight {

    public static void fight(Scanner scanner, List<Character> characters) {
        System.out.println("¡¡Afila el hacha, A Pegarse!!");
        int option;
        while(true) {

            System.out.println("\nMenú Batalla");
            System.out.println("1. Elegir personajes manuales");
            System.out.println("2. BAtalla");
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
}
