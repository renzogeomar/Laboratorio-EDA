package Laboratorio7.EjerciciosPropuestos.Ejercicio3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test{
    public static void main(String[] args) {
        AVL<Integer> arbol = new AVL<>();
        // Inserciones iniciales
        int[] datos = {100, 200, 300, 400, 500, 50, 25, 350, 375, 360, 355, 150, 175, 120, 190};
        for (int dato : datos) {
            arbol.insert(dato);
        }
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        do {
            System.out.println("\n======= MENÚ AVL =======");
            System.out.println("1. Insertar");
            System.out.println("2. Eliminar");
            System.out.println("3. Buscar");
            System.out.println("4. Recorrido InOrden");
            System.out.println("5. Recorrido PreOrden");
            System.out.println("6. Recorrido PostOrden");
            System.out.println("7. Mostrar Árbol (Pretty)");
            System.out.println("8. Exportar a archivo DOT");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese valor a insertar: ");
                        int valorInsertar = scanner.nextInt();
                        arbol.insert(valorInsertar);
                        System.out.println("Insertado.");
                        break;
                    case 2:
                        System.out.print("Ingrese valor a eliminar: ");
                        int valorEliminar = scanner.nextInt();
                        arbol.remove(valorEliminar);
                        System.out.println("Eliminado (si existía).");
                        break;
                    case 3:
                        System.out.print("Ingrese valor a buscar: ");
                        int valorBuscar = scanner.nextInt();
                        if (arbol.search(valorBuscar)) {
                            System.out.println("El valor " + valorBuscar + " está en el árbol.");
                        } 
                        else {
                            System.out.println("El valor " + valorBuscar + " NO se encuentra.");
                        }
                        break;
                    case 4:
                        System.out.print("InOrden: ");
                        arbol.inOrder();
                        System.out.println();
                        break;
                    case 5:
                        System.out.print("PreOrden: ");
                        arbol.preOrder();
                        System.out.println();
                        break;
                    case 6:
                        System.out.print("PostOrden: ");
                        arbol.postOrder();
                        System.out.println();
                        break;
                    case 7:
                        System.out.println("Árbol AVL:");
                        arbol.printPretty();
                        break;
                    case 8:
                        arbol.exportToDot("arbol.dot");
                        System.out.println("Archivo DOT generado.");
                        break;
                    case 0:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Intente de nuevo.");
                scanner.nextLine();
            }

        } while (opcion != 0);

        scanner.close();

    }
}