package Laboratorio8.EjerciciosPropuestos.Ejercicio8;
import java.util.Scanner;

public class Test{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BPlusTree<Integer> tree;

        System.out.print("Ingrese el grado mínimo del B+ Tree (t ≥ 2): ");
        int t = Integer.parseInt(scanner.nextLine());
        tree = new BPlusTree<>(t);

        int opcion=0;
        do {
            System.out.println("\n--- Menú del Árbol B+ ---");
            System.out.println("1. Insertar clave");
            System.out.println("2. Eliminar clave");
            System.out.println("3. Buscar clave");
            System.out.println("4. Mostrar predecesor");
            System.out.println("5. Mostrar sucesor");
            System.out.println("6. Mostrar árbol (toString)");
            System.out.println("7. Mostrar árbol (writeTree)");
            System.out.println("8. Vaciar árbol");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");

            String input = scanner.nextLine();
            if (!input.matches("\\d+")) {
                System.out.println("Entrada inválida. Intente nuevamente.");
                continue;
            }

            opcion = Integer.parseInt(input);

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese la clave a insertar: ");
                    int clave = Integer.parseInt(scanner.nextLine());
                    tree.insert(clave);
                    System.out.println("Clave insertada.");
                }
                case 2 -> {
                    System.out.print("Ingrese la clave a eliminar: ");
                    int clave = Integer.parseInt(scanner.nextLine());
                    tree.remove(clave);
                    System.out.println("Clave eliminada si existía.");
                }
                case 3 -> {
                    System.out.print("Ingrese la clave a buscar: ");
                    int clave = Integer.parseInt(scanner.nextLine());
                    boolean encontrada = tree.search(clave);
                    System.out.println(encontrada ? "Clave encontrada." : "Clave no encontrada.");
                }
                case 4 -> {
                    System.out.print("Ingrese la clave para obtener su predecesor: ");
                    int clave = Integer.parseInt(scanner.nextLine());
                    Integer pred = tree.predecesor(clave);
                    System.out.println(pred != null ? "Predecesor: " + pred : "No hay predecesor.");
                }
                case 5 -> {
                    System.out.print("Ingrese la clave para obtener su sucesor: ");
                    int clave = Integer.parseInt(scanner.nextLine());
                    Integer succ = tree.sucesor(clave);
                    System.out.println(succ != null ? "Sucesor: " + succ : "No hay sucesor.");
                }
                case 6 -> {
                    System.out.println("--- Estructura del árbol (toString) ---");
                    System.out.println(tree);
                }
                case 7 -> {
                    System.out.println("--- Estructura del árbol (writeTree) ---");
                    System.out.println(tree.writeTree());
                }
                case 8 -> {
                    tree.destroy();
                    System.out.println("Árbol vaciado.");
                }
                case 9 -> System.out.println("Saliendo del programa...");
                default -> {
                    if (opcion < 1 || opcion > 9)
                        System.out.println("Opción no válida.");
                }
            }

        } while (opcion != 9);

        scanner.close();
    }
}