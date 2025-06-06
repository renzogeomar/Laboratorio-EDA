package Laboratorio5.EjerciciosPropuestos.Ejercicio4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ejercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QueueList<String> queue = new QueueList<>();
        int option;

        do {
            System.out.println("\n--- MENÚ DE COLA ---");
            System.out.println("1. Agregar un elemento (add)");
            System.out.println("2. Agregar varios elementos (addAll)");
            System.out.println("3. Encolar un elemento directamente (enqueue)");
            System.out.println("4. Eliminar un elemento del frente (dequeue)");
            System.out.println("5. Ver frente (front)");
            System.out.println("6. Ver final (back)");
            System.out.println("7. Ver frente con element()");
            System.out.println("8. ¿La cola está vacía? (isEmpty)");
            System.out.println("9. Limpiar la cola (clear)");
            System.out.println("10. Destruir la cola (destroyQueue)");
            System.out.println("11. Mostrar elementos (printQueue)");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (option) {
                case 1:
                    System.out.print("Elemento a agregar con add: ");
                    String e1 = scanner.nextLine();
                    try {
                        queue.add(e1);
                        System.out.println("Elemento agregado con add.");
                    } 
                    catch (Exception ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Ingresa elementos separados por coma (addAll): ");
                    String line = scanner.nextLine();
                    String[] parts = line.split(",");
                    List<String> elements = new ArrayList<>();
                    for (String part : parts) {
                        elements.add(part.trim());
                    }
                    try {
                        queue.addAll(elements);
                        System.out.println("Elementos agregados con addAll.");
                    } 
                    catch (Exception ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Elemento a encolar directamente (enqueue): ");
                    String e2 = scanner.nextLine();
                    try {
                        queue.enqueue(e2);
                        System.out.println("Elemento encolado con enqueue.");
                    } 
                    catch (Exception ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    break;

                case 4:
                    try {
                        queue.dequeue();
                        System.out.println("Elemento eliminado del frente.");
                    } 
                    catch (Exception ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    break;

                case 5:
                    try {
                        System.out.println("Frente con front(): " + queue.front());
                    } catch (Exception ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    break;

                case 6:
                    try {
                        System.out.println("Final con back(): " + queue.back());
                    } 
                    catch (Exception ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    break;

                case 7:
                    try {
                        System.out.println("Frente con element(): " + queue.element());
                    } 
                    catch (Exception ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    break;

                case 8:
                    System.out.println("¿Está vacía? " + (queue.isEmpty() ? "Sí" : "No"));
                    break;

                case 9:
                    queue.clear();
                    System.out.println("Cola limpiada con clear().");
                    break;

                case 10:
                    queue.destroyQueue();
                    System.out.println("Cola destruida con destroyQueue().");
                    break;

                case 11:
                    queue.printQueue();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (option != 0);

        scanner.close();
    }
}
