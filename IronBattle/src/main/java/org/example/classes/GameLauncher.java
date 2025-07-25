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



    public void launch() {
        System.out.println("          ¡¡⚔️Ironhack Battle!!⚔️");

        int option;

        while (true) {
            System.out.println("\n         Menú principal     ");
            System.out.println("1. Créate unos personajes");
            System.out.println("2.  o Déjate de leches...Y A PEGARSE DIRECTAMENTE!!");
            System.out.println("3. Salir");


            System.out.print("Escribe el número de tu opción: ");
            try {
                option = Integer.parseInt(scanner.nextLine());
                scanner.nextLine();

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
            } catch (NumberFormatException e){
               System.out.println("❗ Debes introducir un número válido.");
            } catch (Exception e) {
                System.out.println("❗ Ocurrió un error inesperado: " + e.getMessage());
             }
                }
            }

        }

    


