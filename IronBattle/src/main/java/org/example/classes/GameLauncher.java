package org.example.classes;

import org.example.classes.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameLauncher {
     Scanner scanner = new Scanner(System.in);
     Random random = new Random();
    private List<Character> characters = new ArrayList<>();


    // Metodo Launch que lanza el primer Scanner.
    public void launch() {
        System.out.println("¡¡Te damos la bienvenida a Ironhack Battle!!");

        int option;

        while (true) {
            System.out.println("\nMenú principal");
            System.out.println("1. Accede al Menu de personajes");
            System.out.println("2. A Pegarse!!");
            System.out.println("3. Salir");


            System.out.print("Elige una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (option) {
                case 1:
                    MenuCreateCharacter.menuCreateCharacters(scanner, characters);
                    break;
                case 2:
                    MenuFight.fight(scanner, characters);
                    break;
                case 3:
                    System.out.println("¡Hasta pronto!");
                    return;
                default:
                    System.out.println("❗ Opción no válida. Intenta de nuevo.");
            }

        }

    }

}
