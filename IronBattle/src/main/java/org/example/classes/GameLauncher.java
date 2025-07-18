import java.util.Scanner;

public class GameLauncher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Lógica
        System.out.println("¡¡Te damos la bienvenida a IronhackBattle!!");

        int option;

        do {
            System.out.println("\nMenú principal");
            System.out.println("1. Crear personaje personalizado");
            System.out.println("2. Crear personaje aleatorio");
            System.out.println("3. Salir");
            System.out.println("Elige una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Has elegido crear un personaje personalizado.");
                    System.out.println("Introduce el nombre de tu personaje: ");
                    String namePj = scanner.nextLine();

                    System.out.println("Elige la clase de tu personaje: ");
                    System.out.println("1. Guerrero");
                    System.out.println("2. Mago");
                    int numPj = scanner.nextInt();
                    scanner.nextLine();

                    String classPj = "";
                    if (numPj == 1) {
                        classPj = "Guerrero"
                    } else if (numPj == 2) {
                        classPj = "Mago"
                    } else {
                        System.out.println("Esa personaje no existe, Se creará un Guerrero por defecto.");
                        classPj = "Guerrero"
                    }

                    //metodo para crear personaje con argumentos namePj, classPj.
                    System.out.println("Personaje " + namePj + " de tipo " + classPj + " creado.");

                    break;
                case 2:
                    System.out.println("Has elegido crear un personaje aleatorio");
                    break;
                case 3:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (option != 3)

        scanner.close();
    }
}