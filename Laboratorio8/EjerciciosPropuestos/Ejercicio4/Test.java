package Laboratorio8.EjerciciosPropuestos.Ejercicio4;
import java.util.Scanner;

public class Test{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int grado = 0;
        do {
            System.out.print("Ingrese el grado máximo (m >= 3) del B-Tree: ");
            grado = scanner.nextInt();
            if (grado < 3) {
                System.out.println("El grado debe ser al menos 3. Intente nuevamente.");
            }
        } while (grado < 3);

        BTree<Integer> btree = new BTree<>(grado);

        int option = -1;
        while (option != 0) {
            System.out.println("\n=== Menú de Operaciones B-Tree ===");
            System.out.println("1. Insertar clave");
            System.out.println("2. Buscar clave");
            System.out.println("3. Eliminar clave");
            System.out.println("4. Mostrar árbol (toString)");
            System.out.println("5. Mostrar árbol (writeTree)");
            System.out.println("6. Obtener predecesor de clave");
            System.out.println("7. Obtener sucesor de clave");
            System.out.println("8. Destruir árbol");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Ingrese la clave a insertar: ");
                    int claveInsertar = scanner.nextInt();
                    btree.insert(claveInsertar);
                    System.out.println("Clave insertada.");
                    break;
                case 2:
                    System.out.print("Ingrese la clave a buscar: ");
                    int claveBuscar = scanner.nextInt();
                    boolean encontrado = btree.search(claveBuscar);
                    System.out.println(encontrado ? "Clave encontrada." : "Clave no encontrada.");
                    break;
                case 3:
                    System.out.print("Ingrese la clave a eliminar: ");
                    int claveEliminar = scanner.nextInt();
                    btree.remove(claveEliminar);  // Activamos el remove
                    System.out.println("Operación de eliminación realizada.");
                    break;
                case 4:
                    System.out.println("Árbol (toString):");
                    System.out.println(btree.toString());
                    break;
                case 5:
                    System.out.println("Árbol (writeTree):");
                    System.out.println(btree.writeTree());
                    break;
                case 6:
                    System.out.print("Ingrese la clave para obtener el predecesor: ");
                    int clavePredecesor = scanner.nextInt();
                    Integer pred = btree.predecesor(clavePredecesor);
                    if (pred != null) {
                        System.out.println("Predecesor: " + pred);
                    } else {
                        System.out.println("No existe predecesor para esa clave.");
                    }
                    break;
                case 7:
                    System.out.print("Ingrese la clave para obtener el sucesor: ");
                    int claveSucesor = scanner.nextInt();
                    Integer succ = btree.sucesor(claveSucesor);
                    if (succ != null) {
                        System.out.println("Sucesor: " + succ);
                    } else {
                        System.out.println("No existe sucesor para esa clave.");
                    }
                    break;
                case 8:
                    btree.destroy();
                    System.out.println("Árbol destruido.");
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }

        scanner.close();

    }
}