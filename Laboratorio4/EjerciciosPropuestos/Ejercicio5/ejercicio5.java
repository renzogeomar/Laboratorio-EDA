package Laboratorio4.EjerciciosPropuestos.Ejercicio5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Agregar elemento al final");
            System.out.println("2. Agregar elemento al inicio");
            System.out.println("3. Agregar elemento en posición");
            System.out.println("4. Agregar colección");
            System.out.println("5. Agregar colección en posición");
            System.out.println("6. Eliminar por valor");
            System.out.println("7. Eliminar por posición");
            System.out.println("8. Eliminar primero");
            System.out.println("9. Eliminar último");
            System.out.println("10. Ver si contiene un elemento");
            System.out.println("11. Clonar lista");
            System.out.println("12. Mostrar lista");
            System.out.println("13. Mostrar lista en orden inverso");
            System.out.println("14. Limpiar lista");
            System.out.println("15. Tamaño de la lista");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el elemento: ");
                    String dato = scanner.nextLine();
                    list.addLast(dato);
                    break;

                case 2:
                    System.out.print("Ingrese el elemento: ");
                    dato = scanner.nextLine();
                    list.addFirst(dato);
                    break;

                case 3:
                    System.out.print("Ingrese el elemento: ");
                    dato = scanner.nextLine();
                    System.out.print("Ingrese la posición: ");
                    int pos = scanner.nextInt();
                    list.add(dato, pos);
                    break;

                case 4:
                    System.out.print("¿Cuántos elementos desea agregar? ");
                    int n = scanner.nextInt();
                    scanner.nextLine();
                    List<String> col = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Elemento " + (i + 1) + ": ");
                        col.add(scanner.nextLine());
                    }
                    list.addAll(col);
                    break;

                case 5:
                    System.out.print("Ingrese la posición inicial: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("¿Cuántos elementos desea agregar? ");
                    int m = scanner.nextInt();
                    scanner.nextLine();
                    List<String> col2 = new ArrayList<>();
                    for (int i = 0; i < m; i++) {
                        System.out.print("Elemento " + (i + 1) + ": ");
                        col2.add(scanner.nextLine());
                    }
                    list.addAll(index, col2);
                    break;

                case 6:
                    System.out.print("Ingrese el valor a eliminar: ");
                    String key = scanner.nextLine();
                    LinkedList.deleteByKey(list, key);
                    break;

                case 7:
                    System.out.print("Ingrese la posición a eliminar: ");
                    int position = scanner.nextInt();
                    LinkedList.deleteAtPosition(list, position);
                    break;

                case 8:
                    list.removeFirst();
                    break;

                case 9:
                    list.removeLast();
                    break;

                case 10:
                    System.out.print("Ingrese el elemento a buscar: ");
                    String element = scanner.nextLine();
                    Object result = list.contains(element);
                    if (result != null) {
                        System.out.println("Elemento encontrado: " + result);
                    } else {
                        System.out.println("Elemento no encontrado.");
                    }
                    break;

                case 11:
                    LinkedList<String> cloned = (LinkedList<String>) list.clone();
                    System.out.print("Lista clonada: ");
                    cloned.printList();
                    break;

                case 12:
                    System.out.print("Lista: ");
                    list.printList();
                    break;

                case 13:
                    System.out.print("Lista en orden inverso: ");
                    Iterator<String> descIt = list.descendingIterator();
                    while (descIt.hasNext()) {
                        System.out.print(descIt.next() + " ");
                    }
                    System.out.println();
                    break;

                case 14:
                    list.clear();
                    System.out.println("Lista limpiada.");
                    break;

                case 15:
                    System.out.println("Tamaño de la lista: " + list.size());
                    break;

                case 0:
                    exit = true;
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }  
}