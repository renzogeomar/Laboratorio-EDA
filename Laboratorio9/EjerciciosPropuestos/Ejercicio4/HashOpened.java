package Laboratorio9.EjerciciosPropuestos.Ejercicio4;
import java.util.LinkedList;

public class HashOpened <E>{
    private LinkedList<Register<E>>[] table; // Array de listas enlazadas

    @SuppressWarnings("unchecked")
    public HashOpened(int capacity) { // Constructor que inicializa la tabla hash
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }
    private int hash(int key) { // Función hash que calcula el índice de la tabla
        return key % table.length;
    }
    public void insert(Register<E> reg) { // Método para insertar un registro en la tabla hash
        int index = hash(reg.getKey()); // Calcular el índice usando la función hash
        for (Register<E> r : table[index]) { // Recorrer la lista enlazada en el índice calculado
            if (r.getKey() == reg.getKey() && !r.isDeleted()) { // Verificar si la clave ya existe y no está eliminada
                System.out.println("Clave duplicada: " + reg.getKey()); // Si la clave ya existe, no se inserta
                return;
            }
        }
        table[index].add(reg); // Agregar el registro a la lista enlazada en el índice
        System.out.println("Insertado: " + reg);
    }
    public void delete(int key) { // Método para eliminar un registro lógicamente
        int index = hash(key); // Calcular el índice usando la función hash
            for (Register<E> r : table[index]) { // Recorrer la lista enlazada en el índice calculado
                if (r.getKey() == key && !r.isDeleted()) { // Verificar si la clave existe y no está eliminada
                    r.delete();
                    System.out.println("Eliminado lógicamente: " + key); // Marcar el registro como eliminado
                    return;
                }
            }
        System.out.println("Clave no encontrada: " + key);
    }
    public Register<E> search(int key) { // Método para buscar un registro por su clave
        int index = hash(key); // Calcular el índice usando la función hash
        for (Register<E> r : table[index]) { // Recorrer la lista enlazada en el índice calculado
            if (r.getKey() == key && !r.isDeleted()) { // Verificar si la clave existe y no está eliminada
                return r;
            }
        }
        return null;
    }
    public void showTable() { // Método para mostrar el estado de la tabla hash
        System.out.println("\n--- Estado de la Tabla Hash (Abierto) ---");
        for (int i = 0; i < table.length; i++) { // Recorrer cada índice de la tabla
            System.out.print(i + ": ");
            if (table[i].isEmpty()) { // Si la lista enlazada está vacía
                System.out.println("[VACÍO]");
            } else {
                for (Register<E> r : table[i]) { // Recorrer la lista enlazada en el índice
                    System.out.print(r + " -> ");
                }       
                System.out.println("null");
            }
        }
    }
    public E getValueByKey(int key) { // Método para obtener el valor asociado a una clave
        Register<E> reg = search(key); // Buscar el registro por su clave
        return (reg != null) ? reg.getValue() : null; // Si se encuentra, devolver el valor; si no, devolver null
    }
}
