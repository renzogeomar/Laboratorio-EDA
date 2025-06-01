package Laboratorio4.EjerciciosPropuestos.Ejercicio7;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ejercicio7 {
    public static void main(String[] args) {
        LinkedListCircular<Integer> list = new LinkedListCircular<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menú LinkedListCircular ---");
            System.out.println("1. Agregar al final (add / addLast)");
            System.out.println("2. Agregar al inicio (addFirst)");
            System.out.println("3. Agregar en posición (add con posición)");
            System.out.println("4. Agregar colección completa");
            System.out.println("5. Imprimir lista");
            System.out.println("6. Clonar lista");
            System.out.println("7. Buscar elemento (contains)");
            System.out.println("8. Obtener elemento por índice (get)");
            System.out.println("9. Eliminar por valor (deleteByKey)");
            System.out.println("10. Eliminar por posición (deleteAtPosition)");
            System.out.println("11. Remover primero (removeFirst)");
            System.out.println("12. Remover último (removeLast)");
            System.out.println("13. Mostrar tamaño");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese número para agregar al final: ");
                    int valAdd = sc.nextInt();
                    list.addLast(valAdd);
                    System.out.println("Agregado.");
                    break;
                case 2:
                    System.out.print("Ingrese número para agregar al inicio: ");
                    int valAddFirst = sc.nextInt();
                    list.addFirst(valAddFirst);
                    System.out.println("Agregado al inicio.");
                    break;
                case 3:
                    System.out.print("Ingrese número para agregar: ");
                    int valPos = sc.nextInt();
                    System.out.print("Ingrese posición (0-based): ");
                    int pos = sc.nextInt();
                    list.add(valPos, pos);
                    System.out.println("Agregado en posición " + pos);
                    break;
                case 4:
                    System.out.println("Ingrese números separados por espacio para agregar (ej: 1 2 3):");
                    String line = sc.nextLine();
                    String[] parts = line.trim().split("\\s+");
                    List<Integer> coll = new ArrayList<>();
                    for (String p : parts) {
                        coll.add(Integer.parseInt(p));
                    }
                    list.addAll(coll);
                    System.out.println("Colección agregada.");
                    break;
                case 5:
                    System.out.print("Lista: ");
                    list.printList();
                    break;
                case 6:
                    LinkedListCircular<Integer> cloned = (LinkedListCircular<Integer>) list.clone();
                    System.out.print("Lista clonada: ");
                    cloned.printList();
                    break;
                case 7:
                    System.out.print("Ingrese elemento a buscar: ");
                    int buscar = sc.nextInt();
                    boolean encontrado = list.contains(buscar);
                    System.out.println(encontrado ? "Elemento encontrado." : "Elemento no encontrado.");
                    break;
                case 8:
                    System.out.print("Ingrese índice: ");
                    int index = sc.nextInt();
                    try {
                        int element = list.get(index);
                        System.out.println("Elemento en índice " + index + ": " + element);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Índice fuera de rango.");
                    }
                    break;
                case 9:
                    System.out.print("Ingrese elemento a eliminar: ");
                    int delKey = sc.nextInt();
                    boolean eliminado = list.deleteByKey(delKey);
                    System.out.println(eliminado ? "Elemento eliminado." : "Elemento no encontrado.");
                    break;
                case 10:
                    System.out.print("Ingrese posición a eliminar: ");
                    int delPos = sc.nextInt();
                    boolean elimPos = list.deleteAtPosition(delPos);
                    System.out.println(elimPos ? "Elemento eliminado." : "Posición inválida.");
                    break;
                case 11:
                    boolean remFirst = list.removeFirst();
                    System.out.println(remFirst ? "Primer elemento removido." : "Lista vacía.");
                    break;
                case 12:
                    boolean remLast = list.removeLast();
                    System.out.println(remLast ? "Último elemento removido." : "Lista vacía.");
                    break;
                case 13:
                    System.out.println("Tamaño de la lista: " + list.size());
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        }
    }
}
