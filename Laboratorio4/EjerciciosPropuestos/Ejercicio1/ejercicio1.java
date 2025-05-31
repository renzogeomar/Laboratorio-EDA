package Laboratorio4.EjerciciosPropuestos.Ejercicio1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class ejercicio1 {
    public static void main(String[] args) {
        LinkedListDouble<Integer> listEnteros = new LinkedListDouble<>();
        LinkedListDouble<String> listCadenas = new LinkedListDouble<>();
        
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

        LinkedListDouble<String> list = new LinkedListDouble<>();
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

        // -------------------Probando addFirst y addLast----------------------------
        System.out.println("-------------------Probando addFirst y addLast----------------------------");
        LinkedListDouble<String> list2 = new LinkedListDouble<>();
        // Agregar elementos al principio y al final de la lista
        list2.addFirst("Inicio");
        list2.add("prueba");
        list2.add("prueba2");
        list2.addLast("Final");
        list2.printList(); // Imprime: Inicio Final

        // -------------------Probando clear y clone----------------------------
        System.out.println("-------------------Probando clear y clone----------------------------");
        LinkedListDouble<String> list3 = new LinkedListDouble<>();
        list3.add("Elemento1");
        list3.add("Elemento2");
        System.out.println("Lista original:");
        list3.printList(); 
        LinkedListDouble<String> clonedList = (LinkedListDouble<String>) list3.clone(); // Clona la lista
        list3.clear(); // Limpia la lista
        System.out.println("Lista después de clear:");
        list3.printList(); // Imprime: (lista vacía)
        System.out.println("Lista clonada:");
        clonedList.printList(); 

        // -------------------Probando contains y descendingIterator----------------------------
        System.out.println("-------------------Probando contains y descendingIterator----------------------------");
        LinkedListDouble<String> list4 = new LinkedListDouble<>();
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
}