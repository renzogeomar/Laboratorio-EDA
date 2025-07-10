package Laboratorio9.EjerciciosResueltos.Ejercicio1;

public class HashClosed <E>{
    private Register<E>[] table;
    private int capacity;

    @SuppressWarnings("unchecked")
    public HashClosed(int capacity) {
        this.capacity = capacity;
        table = new Register[capacity];
    }
    private int hash(int key) {
        return key % capacity;
    }
    public void insert(Register<E> reg) {
        int index = hash(reg.getKey());
        int startIndex = index;
        do {
            Register<E> current = table[index];
            if (current == null || current.isDeleted()) {
                table[index] = reg;
                System.out.println("Insertado en índice " + index + ": " + reg);
                return;
            } 
            else if (current.getKey() == reg.getKey() && !current.isDeleted()) {
                System.out.println("Clave duplicada: " + reg.getKey());
                return;
            }
            index = (index + 1) % capacity;
        } while (index != startIndex);
        System.out.println("Tabla llena, no se pudo insertar: " + reg);
    }
    public Register<E> search(int key) {
        int index = hash(key);
        int startIndex = index;
        do {
            Register<E> current = table[index];
            if (current == null) {
                return null; // No encontrado
            } 
            else if (current.getKey() == key && !current.isDeleted()) {
                return current;
            }
            index = (index + 1) % capacity;
        } while (index != startIndex);
        return null; // No encontrado
    }
}