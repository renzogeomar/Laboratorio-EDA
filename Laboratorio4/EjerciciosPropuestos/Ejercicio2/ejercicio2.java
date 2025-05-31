package Laboratorio4.EjerciciosPropuestos.Ejercicio2;
import java.util.Arrays;
import java.util.Collection;

public class ejercicio2 {
    public static void main(String[] args) {
        LinkedListCircular<Integer> listEnteros = new LinkedListCircular<>();
        LinkedListCircular<String> listCadenas = new LinkedListCircular<>();
        
        // Agregar elementos a la lista
        listEnteros.add(1);
        listEnteros.add(2);
        listEnteros.add(3);
        listCadenas.add("Hola");
        listCadenas.add("Mundo");
        
        // Agregar un elemento en una posición específica
        listEnteros.add(4, 2); 
        listCadenas.add("Java", 1);
        
        listEnteros.printList(); 
        listCadenas.printList();

        // -------------------Probando addAll----------------------------
        System.out.println("-------------------Probando addAll----------------------------");
        LinkedListCircular<String> list = new LinkedListCircular<>();
        // Crear una colección
        Collection<String> collection1 = Arrays.asList("A", "B", "C");
        // Probar addAll(Collection)
        System.out.println("Agregando colección al final:");
        list.addAll(collection1);
        list.printList();
        // Crear otra colección
        Collection<String> collection2 = Arrays.asList("X", "Y");
        // Probar addAll(int index, Collection)
        System.out.println("Agregando colección en la posición 1:");
        list.addAll(1, collection2);
        list.printList();

    }
}
