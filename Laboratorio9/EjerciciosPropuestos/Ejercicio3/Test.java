package Laboratorio9.EjerciciosPropuestos.Ejercicio3;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese la capacidad de la tabla hash: ");
        int capacity = scan.nextInt();
        scan.nextLine(); 

        HashClosed<String> hashTable = new HashClosed<>(capacity);

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- Menú Hash Cerrado ---");
            System.out.println("1. Insertar");
            System.out.println("2. Buscar");
            System.out.println("3. Eliminar");
            System.out.println("4. Mostrar tabla");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scan.nextInt();
            scan.nextLine();  // Consumir salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la clave (int): ");
                    int claveInsert = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Ingrese el valor (String): ");
                    String valorInsert = scan.nextLine();
                    Register<String> regInsert = new Register<>(claveInsert, valorInsert);
                    hashTable.insert(regInsert);
                    break;

                case 2:
                    System.out.print("Ingrese la clave a buscar: ");
                    int claveBuscar = scan.nextInt();
                    scan.nextLine();
                    Register<String> regBuscar = hashTable.search(claveBuscar);
                    if (regBuscar != null && !regBuscar.isDeleted()) {
                        System.out.println("Encontrado: " + regBuscar);
                    } 
                    else {
                        System.out.println("No encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese la clave a eliminar: ");
                    int claveEliminar = scan.nextInt();
                    scan.nextLine();
                    hashTable.delete(claveEliminar);
                    break;

                case 4:
                    hashTable.showTable();
                    break;

                case 5:
                    salir = true;
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }

        scan.close();
    }
}
