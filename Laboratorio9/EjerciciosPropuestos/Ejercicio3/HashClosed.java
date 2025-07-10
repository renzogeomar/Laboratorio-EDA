package Laboratorio9.EjerciciosPropuestos.Ejercicio3;

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
    public void delete(int key) {
        int index = hash(key);
        int startIndex = index;
        do {
            Register<E> current = table[index];
            if (current == null) {
                System.out.println("Clave no encontrada: " + key);
                return;
            } 
            else if (current.getKey() == key && !current.isDeleted()) {
                current.delete();
                System.out.println("Eliminado lógicamente: " + key + " en índice " + index);
                return;
            }
            index = (index + 1) % capacity;
        } while (index != startIndex);
        System.out.println("Clave no encontrada: " + key);
    }
    public void showTable() {
        System.out.println("\n--- Estado de la Tabla Hash (Cerrado) ---");
        for (int i = 0; i < capacity; i++) {
            System.out.print(i + ": ");
            if (table[i] == null) {
                System.out.println("[VACÍO]");
            } else {
                System.out.print(table[i] + " -> ");
                System.out.println("null");
            }
        }
    }
    public E getValueByKey(int key) {
        Register<E> reg = search(key);
        return (reg != null) ? reg.getValue() : null;
    }

}