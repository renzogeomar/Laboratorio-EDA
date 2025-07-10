package Laboratorio9.EjerciciosResueltos.Ejercicio2;

public class Test {
    public static void main(String[] args) {
        // Crear tabla hash con tamaño 8
        HashOpened<String> hashTable = new HashOpened<>(8);

        // Agregar elementos
        hashTable.insert(new Register<>(5, "Pepe"));
        hashTable.insert(new Register<>(21, "Jesús"));
        hashTable.insert(new Register<>(19, "Juan"));
        hashTable.insert(new Register<>(16, "María"));
        hashTable.insert(new Register<>(21, "DUPLICADO")); // Clave duplicada

        // Mostrar tabla hash
        hashTable.showTable();

        // Buscar elementos
        System.out.println("\nBuscando elementos:");
        System.out.println("Clave 5: " + hashTable.search(5));
        System.out.println("Clave 21: " + hashTable.search(21));

        // Eliminar elementos
        System.out.println("\nEliminando elementos:");
        hashTable.delete(21); // Eliminar clave existente
        hashTable.delete(100); // Eliminar clave inexistente

        // Mostrar tabla hash resultante
        hashTable.showTable();
    }
}
