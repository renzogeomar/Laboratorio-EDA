package Laboratorio4.EjerciciosPropuestos.Ejercicio6;

import java.util.Arrays;
//import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class ejercicio6 {
    /*
     * Ejercicio 6:
     * Implementar una lista doblemente enlazada que tenga los elementos del 1 al 10, usando la clase nodo en 
     * java y modificar los métodos vistos en los ejercicios propuestos (insert, printList, deleteByKey, 
     * deleteAtPosition, size, removeFirst, removela
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedListDouble<String> lista = new LinkedListDouble<>();

        int opcion;
        do {
            System.out.println("\n--- MENÚ DE OPERACIONES ---");
            System.out.println("1. Agregar elemento al final (add)");
            System.out.println("2. Agregar elemento en posición específica (add con índice)");
            System.out.println("3. Agregar colección al final (addAll)");
            System.out.println("4. Agregar colección en una posición específica (addAll con índice)");
            System.out.println("5. Agregar al inicio (addFirst)");
            System.out.println("6. Agregar al final (addLast)");
            System.out.println("7. Limpiar lista (clear)");
            System.out.println("8. Clonar lista (clone)");
            System.out.println("9. Buscar elemento (contains)");
            System.out.println("10. Mostrar lista (printList)");
            System.out.println("11. Mostrar lista en orden descendente");
            System.out.println("12. Insertar elemento (método estático insert)");
            System.out.println("13. Eliminar por valor (método estático deleteByKey)");
            System.out.println("14. Eliminar por posición (método estático deleteAtPosition)");
            System.out.println("15. Tamaño de la lista (size)");
            System.out.println("16. Eliminar primer elemento (removeFirst)");
            System.out.println("17. Eliminar último elemento (removeLast)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un elemento para agregar al final: ");
                    String elem1 = scanner.nextLine();
                    lista.add(elem1);
                    System.out.println("Elemento agregado.");
                    break;

                case 2:
                    System.out.print("Ingrese un elemento para agregar: ");
                    String elem2 = scanner.nextLine();
                    System.out.print("Ingrese la posición: ");
                    int pos2 = scanner.nextInt();
                    scanner.nextLine();
                    lista.add(elem2, pos2);
                    System.out.println("Elemento agregado en la posición " + pos2);
                    break;

                case 3:
                    System.out.print("Ingrese elementos separados por coma para agregar al final: ");
                    String[] elems3 = scanner.nextLine().split(",");
                    lista.addAll(Arrays.asList(elems3));
                    System.out.println("Colección agregada al final.");
                    break;

                case 4:
                    System.out.print("Ingrese elementos separados por coma para agregar: ");
                    String[] elems4 = scanner.nextLine().split(",");
                    System.out.print("Ingrese la posición para agregar la colección: ");
                    int pos4 = scanner.nextInt();
                    scanner.nextLine();
                    lista.addAll(pos4, Arrays.asList(elems4));
                    System.out.println("Colección agregada en la posición " + pos4);
                    break;

                case 5:
                    System.out.print("Ingrese un elemento para agregar al inicio: ");
                    String elem5 = scanner.nextLine();
                    lista.addFirst(elem5);
                    System.out.println("Elemento agregado al inicio.");
                    break;

                case 6:
                    System.out.print("Ingrese un elemento para agregar al final (addLast): ");
                    String elem6 = scanner.nextLine();
                    lista.addLast(elem6);
                    System.out.println("Elemento agregado al final.");
                    break;

                case 7:
                    lista.clear();
                    System.out.println("Lista limpiada.");
                    break;

                case 8:
                    @SuppressWarnings("unchecked")
                    LinkedListDouble<String> clonada = (LinkedListDouble<String>) lista.clone();
                    System.out.println("Lista clonada:");
                    clonada.printList();
                    break;

                case 9:
                    System.out.print("Ingrese el elemento a buscar: ");
                    String buscar = scanner.nextLine();
                    String encontrado = lista.contains(buscar);
                    if (encontrado != null) {
                        System.out.println("Elemento encontrado: " + encontrado);
                    } else {
                        System.out.println("Elemento no encontrado.");
                    }
                    break;

                case 10:
                    System.out.println("Contenido de la lista:");
                    lista.printList();
                    break;

                case 11:
                    System.out.println("Lista en orden descendente:");
                    Iterator<String> it = lista.descendingIterator();
                    while (it.hasNext()) {
                        System.out.print(it.next() + " ");
                    }
                    System.out.println();
                    break;

                case 12:
                    System.out.print("Ingrese un elemento para insertar (método estático insert): ");
                    String elem12 = scanner.nextLine();
                    lista = LinkedListDouble.insert(lista, elem12);
                    System.out.println("Elemento insertado.");
                    break;

                case 13:
                    System.out.print("Ingrese el elemento a eliminar (método estático deleteByKey): ");
                    String elem13 = scanner.nextLine();
                    lista = LinkedListDouble.deleteByKey(lista, elem13);
                    break;

                case 14:
                    System.out.print("Ingrese la posición a eliminar (método estático deleteAtPosition): ");
                    int pos14 = scanner.nextInt();
                    scanner.nextLine();
                    lista = LinkedListDouble.deleteAtPosition(lista, pos14);
                    break;

                case 15:
                    System.out.println("Tamaño de la lista: " + lista.size());
                    break;

                case 16:
                    lista.removeFirst();
                    break;

                case 17:
                    lista.removeLast();
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }

}