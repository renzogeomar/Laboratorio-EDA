package Laboratorio9.EjerciciosResueltos.Ejercicio1;

public class Test {
    public static void main(String[] args) {
        // Crear tabla hash con tamaño 11
        HashClosed<Integer> hashTable = new HashClosed<>(11);

        // Insertar elementos (clave = valor)
        int[] keys = {100, 5, 14, 15, 22, 16, 17, 32, 13, 32, 100};
        System.out.println("Insertando elementos:");
        for (int key : keys) {
            hashTable.insert(new Register<>(key, key));
        }

        // Mostrar tabla resultante
        hashTable.showTable();

        // Buscar elementos 32 y 200
        System.out.println("\nBuscando elementos:");
        System.out.println("Clave 32: " + hashTable.search(32));
        System.out.println("Clave 200: " + hashTable.search(200));  // No existe

        // Eliminar elementos 17 y 100
        System.out.println("\nEliminando elementos:");
        hashTable.delete(17);
        hashTable.delete(100);

        // Mostrar tabla resultante luego de eliminar
        hashTable.showTable();

        // Opcional: pruebas adicionales
        System.out.println("\nPrueba adicional: insertar clave 100 nuevamente después de eliminar");
        hashTable.insert(new Register<>(100, 100));
        hashTable.showTable();

    }
}
