package Laboratorio5.EjerciciosPropuestos.Ejercicio2;

import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        StackList<Integer> stack = new StackList<>();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- Menú de Operaciones con StackList ---");
            System.out.println("1. Push (Agregar elemento)");
            System.out.println("2. Pop (Eliminar elemento en la cima)");
            System.out.println("3. Top (Mostrar elemento en la cima)");
            System.out.println("4. PrintStack (Imprimir pila)");
            System.out.println("5. Search (Buscar elemento)");
            System.out.println("6. DestroyStack (Vaciar pila)");
            System.out.println("7. IsEmpty (Verificar si la pila está vacía)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Ingrese el elemento a agregar: ");
                    int element = scanner.nextInt();
                    stack.push(element);
                    System.out.println("Elemento agregado.");
                    break;
                case 2:
                    try {
                        stack.pop();
                        System.out.println("Elemento en la cima eliminado.");
                    } catch (IllegalStateException e) {
                        System.out.println("Error: La pila está vacía.");
                    }
                    break;
                case 3:
                    try {
                        System.out.println("El elemento en la cima es: " + stack.top());
                    } catch (IllegalStateException e) {
                        System.out.println("Error: La pila está vacía.");
                    }
                    break;
                case 4:
                    System.out.println("Contenido de la pila:");
                    stack.printStack();
                    break;
                case 5:
                    System.out.print("Ingrese el elemento a buscar: ");
                    int searchElement = scanner.nextInt();
                    Integer position = stack.search(searchElement);
                    if (position != null && position != -1) {
                        System.out.println("El elemento se encuentra en la posición: " + position);
                    } else {
                        System.out.println("El elemento no se encuentra en la pila.");
                    }
                    break;
                case 6:
                    stack.destroyStack();
                    System.out.println("La pila ha sido vaciada.");
                    break;
                case 7:
                    if (stack.isEmpty()) {
                        System.out.println("La pila está vacía.");
                    } else {
                        System.out.println("La pila no está vacía.");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (option != 0);

        scanner.close();


    }
}
