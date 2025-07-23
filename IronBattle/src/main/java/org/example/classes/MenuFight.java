package org.example.classes;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MenuFight {

    public static void fight(Scanner scanner, List<Character> characters) {
        System.out.println("¡¡Afila el hacha, A Pegarse!!");
        int option;
        while(true) {

            System.out.println("\nMenú Batallas");
            System.out.println("1. Elegir personajes manuales");
            System.out.println("2. Batalla con personajes Random");
            System.out.println("3. Mostrar personajes creados");
            System.out.println("4. Vuelve al Menú principal");
            System.out.print("Elige una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (option) {
                case 1:
                    chooseCharacters(scanner, characters);
                    break;
                case 2:
                    battle(scanner, characters);
                    break;
                case 3:
                    MenuCreateCharacter.showAllCharacters(scanner,characters);
                    break;
                case 4:
                    System.out.println("Volvemos atrás!");
                    return;
                default:
                    System.out.println("❗ Opción no válida. Intenta de nuevo.");
            }

        }


    }

    private static void chooseCharacters(Scanner scanner, List<Character> characters) {
MenuCreateCharacter.showAllCharacters(scanner,characters);
        System.out.print("Elige el número del primer personaje: ");
        int idx1 = scanner.nextInt();
        System.out.print("Elige el número del segundo personaje: ");
        int idx2 = scanner.nextInt() ;
        scanner.nextLine(); // Limpiar buffer

        if (idx1 < 0 || idx1 >= characters.size() || idx2 < 0 || idx2 >= characters.size() || idx1 == idx2) {
            System.out.println("❗ Selección inválida. Intenta de nuevo.");
            return;
        }

        Character pj1 = characters.get(idx1 -1);
        Character pj2 = characters.get(idx2 -1);

        System.out.println("\n Dale al Enter para continuar");
        String input = scanner.nextLine();
        battleCustom(pj1, pj2);

    }

    private static void battleCustom(Character pj1, Character pj2) {
        Scanner scanner = new Scanner(System.in);
// empieza el combate
        int round = 1;
        System.out.println("\n-+-+-+-+-+-+-+ Es la Hora de las Tortas -+-+-+-+--+-");
        System.out.println(pj1.getName() +" VS " + pj2.getName());
        System.out.println("\n");

        while (pj1.getIsAlive() && pj2.getIsAlive()) {
            // decir por pantalla en que round estamos

            System.out.println("-+-+-+-+-+-+-+ Round "+ round +" -+-+-+-+--+-");
            // vamos a ejecutar las funciones Attack de pj1 y pj2

            pj1.attack(pj2);
            pj2.attack(pj1);

            System.out.println("\n Dale al Enter para continuar");
            String input = scanner.nextLine();

            // vamos a sumar 1 al round
            round++;
            System.out.println("\n Ding ding ding Round finalizado!! cada uno a su esquina!! ");
        }
        if (pj1.getIsAlive() && pj2.getIsAlive()) {
            System.out.println("\nLo nunca visto!! Es un Fantástico Empate!!! Ambos Contendientes están en " +
                    "pie!!");

            battleCustom(pj1, pj2);
        } else if (pj1.getIsAlive()) {
            System.out.println("EL Ganador Es El Increíble: " + pj1.getName() + " El " + pj1.getClass());
        } else {
            System.out.println("EL Ganador Es El Increíble: " + pj2.getName() + " El " + pj2.getClass());
        }
    }

    private static void battle(Scanner scanner,List<Character> characters) {
        // elegimos dos personajes Random
        if (characters.isEmpty()){
             while (characters.size() < 3){
                MenuCreateCharacter.createRandomCharacter(scanner, characters);
            }

        }

        int i = new Random().nextInt(characters.size());
        Character pj1 = characters.get(i);
        i = new Random().nextInt(characters.size());
        Character pj2 = characters.get(i);

        // empieza el combate
        int round = 1;
        System.out.println("-+-+-+-+-+-+-+ Es la Hora de las Tortas -+-+-+-+--+-");
        System.out.println(pj1.getName() +" VS " + pj2.getName());

        while (pj1.getIsAlive() && pj2.getIsAlive()) {
            // decir por pantalla en que round estamos

            System.out.println("-+-+-+-+-+-+-+ Round "+ round +" -+-+-+-+--+-");
            // vamos a ejecutar las funciones Attack de pj1 y pj2

            pj1.attack(pj2);
            pj2.attack(pj1);

            System.out.println("\n Dale al Enter para continuar");
            String input = scanner.nextLine();

            // vamos a sumar 1 al round
            round++;
            System.out.println("\n Ding ding ding Round finalizado!! cada uno a su esquina!! ");
            /*if (pj1.getHp() <= 0) {
                pj1.setIsAlive(false);
            }
            if (pj2.getHp() <= 0) {
                pj2.setIsAlive(false);
            }*/
        }
        if (pj1.getIsAlive() && pj2.getIsAlive()) {
            System.out.println("Lo nunca visto!! Es un Fantástico Empate!!! Ambos Contendientes están en " +
                    "pie!!");

            battleCustom(pj1, pj2);
        } else if (pj1.getIsAlive()) {
            System.out.println("EL Ganador Es El Increíble: " + pj1.getName() + " El " + pj1.getClass().getName());
        } else {
            System.out.println("EL Ganador Es El Increíble: " + pj2.getName() + " El " + pj2.getClass().getName());
        }
        }




}







