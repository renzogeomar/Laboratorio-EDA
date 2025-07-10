package Laboratorio9.EjerciciosPropuestos.Ejercicio3;

public class HashClosed <E>{
    private Register<E>[] table;
    private int capacity;

    @SuppressWarnings("unchecked")
    public HashClosed(int capacity) { 
        this.capacity = capacity;
        table = new Register[capacity];
    }
    private int hash(int key) { // Función hash simple
        return key % capacity; // Asegura que el índice esté dentro del rango de la tabla
    }
    public void insert(Register<E> reg) { // Método para insertar un registro en la tabla hash
        int index = hash(reg.getKey()); // Calcular el índice usando la función hash
        int startIndex = index; // Guardar el índice inicial para evitar ciclos infinitos
        do {
            Register<E> current = table[index]; // Obtener el registro actual en el índice calculado
            if (current == null || current.isDeleted()) { // Si el índice está vacío o el registro está eliminado
                table[index] = reg; // Insertar el nuevo registro
                System.out.println("Insertado en índice " + index + ": " + reg);
                return;
            } 
            else if (current.getKey() == reg.getKey() && !current.isDeleted()) { // Verificar si la clave ya existe y no está eliminada
                System.out.println("Clave duplicada: " + reg.getKey());
                return;
            }
            index = (index + 1) % capacity; // Mover al siguiente índice usando sondeo lineal
        } while (index != startIndex); // Repetir hasta que se vuelva al índice inicial
        System.out.println("Tabla llena, no se pudo insertar: " + reg);
    }
    public Register<E> search(int key) { // Método para buscar un registro por su clave
        int index = hash(key); // Calcular el índice usando la función hash
        int startIndex = index; // Guardar el índice inicial para evitar ciclos infinitos
        do {
            Register<E> current = table[index]; // Obtener el registro actual en el índice calculado
            if (current == null) { // Si el índice está vacío, no se encontró el registro
                return null; // No encontrado
            } 
            else if (current.getKey() == key && !current.isDeleted()) { // Verificar si la clave existe y no está eliminada
                return current; 
            }
            index = (index + 1) % capacity; // Mover al siguiente índice usando sondeo lineal
        } while (index != startIndex); // Repetir hasta que se vuelva al índice inicial
        return null; // No encontrado
    }
    public void delete(int key) { // Método para eliminar un registro lógicamente
        int index = hash(key); // Calcular el índice usando la función hash
        int startIndex = index; // Guardar el índice inicial para evitar ciclos infinitos
        do {
            Register<E> current = table[index]; // Obtener el registro actual en el índice calculado
            if (current == null) { // Si el índice está vacío, no se encontró el registro
                System.out.println("Clave no encontrada: " + key);
                return;
            } 
            else if (current.getKey() == key && !current.isDeleted()) { // Verificar si la clave existe y no está eliminada
                current.delete(); // Marcar el registro como eliminado
                System.out.println("Eliminado lógicamente: " + key + " en índice " + index); // Mostrar mensaje de eliminación
                return;
            }
            index = (index + 1) % capacity; // Mover al siguiente índice usando sondeo lineal
        } while (index != startIndex); // Repetir hasta que se vuelva al índice inicial
        System.out.println("Clave no encontrada: " + key);
    }
    public void showTable() {
        System.out.println("\n--- Estado de la Tabla Hash (Cerrado) ---");
        for (int i = 0; i < capacity; i++) {
            System.out.print(i + ": ");
            if (table[i] == null) {
                System.out.println("[VACÍO]");
            } 
            else {
                System.out.print(table[i] + " -> ");
                System.out.println("null");
            }
        }
    }
    public E getValueByKey(int key) { // Método para obtener el valor asociado a una clave
        Register<E> reg = search(key); // Buscar el registro por su clave
        return (reg != null) ? reg.getValue() : null; // Si se encuentra, devolver el valor; si no, devolver null
    }

}