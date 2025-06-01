package Laboratorio4.EjerciciosPropuestos.Ejercicio3;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Collection;

public class ejercicio3 {
    public static void main(String[] args) {
        LinkedList<Integer> listEnteros = new LinkedList<>();
        LinkedList<String> listCadenas = new LinkedList<>();
        
        // Agregar elementos a la lista
        listEnteros.add(1);
        listEnteros.add(2);
        listEnteros.add(3);
        listCadenas.add("Hola");
        listCadenas.add("Mundo");
        
        // Agregar un elemento en una posición específica
        listEnteros.add(2, 4); // (index, element)
        listCadenas.add(1, "java");
        
        printList(listEnteros); 
        printList(listCadenas);

        // -------------------Probando addAll----------------------------
        System.out.println("-------------------Probando addAll----------------------------");

        LinkedList<String> list = new LinkedList<>();
        // Crear una colección
        Collection<String> collection1 = Arrays.asList("A", "B", "C");
        // Probar addAll(Collection)
        System.out.println("Agregando colección al final:");
        list.addAll(collection1);
        printList(list); 
        // Crear otra colección
        Collection<String> collection2 = Arrays.asList("X", "Y");
        // Probar addAll(int index, Collection)
        System.out.println("Agregando colección en la posición 1:");
        list.addAll(1, collection2);
        printList(list); 

        // -------------------Probando addFirst y addLast----------------------------
        System.out.println("-------------------Probando addFirst y addLast----------------------------");
        LinkedList<String> list2 = new LinkedList<>();
        // Agregar elementos al principio y al final de la lista
        list2.addFirst("Inicio");
        list2.add("prueba");
        list2.add("prueba2");
        list2.addLast("Final");
        printList(list2); 

        // -------------------Probando clear y clone----------------------------
        System.out.println("-------------------Probando clear y clone----------------------------");
        LinkedList<String> list3 = new LinkedList<>();
        list3.add("Elemento1");
        list3.add("Elemento2");
        System.out.println("Lista original:");
        printList(list3); 
        LinkedList<String> clonedList = (LinkedList<String>) list3.clone(); // Clona la lista
        list3.clear(); // Limpia la lista
        System.out.println("Lista después de clear:");
        printList(list3); 
        System.out.println("Lista clonada:");
        printList(clonedList); 

        // -------------------Probando contains y descendingIterator----------------------------
        System.out.println("-------------------Probando contains y descendingIterator----------------------------");
        LinkedList<String> list4 = new LinkedList<>();
        list4.add("Elemento1");
        list4.add("Elemento2");
        list4.add("Elemento3");
        list4.add("Elemento4");
        System.out.println("Lista contiene 'Elemento1': " + list4.contains("Elemento1")); 
        System.out.println("Lista contiene 'Elemento3': " + list4.contains("Elemento5")); 
        System.out.println("Iterando en orden descendente:");
        Iterator<String> it = list4.descendingIterator();
        while (it.hasNext()) {
            System.out.println(it.next()); 
        }

    }
    public static void printList(LinkedList<?> list) {
        for (Object item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
    
}
