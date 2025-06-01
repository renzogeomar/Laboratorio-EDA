package Laboratorio4.EjerciciosPropuestos.Ejercicio5;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class ejercicio5 {
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
        listEnteros.add(4, 2); 
        listCadenas.add("Java", 1);
        
        listEnteros.printList(); 
        listCadenas.printList();

        // -------------------Probando addAll----------------------------
        System.out.println("-------------------Probando addAll----------------------------");
        LinkedList<String> list = new LinkedList<>();
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
        LinkedList<String> list2 = new LinkedList<>();
        // Agregar elementos al principio y al final de la lista
        list2.addFirst("Inicio");
        list2.add("prueba");
        list2.add("prueba2");
        list2.addLast("Final");
        list2.printList();
        
        // -------------------Probando clear y clone----------------------------
        System.out.println("-------------------Probando clear y clone----------------------------");
        LinkedList<String> list3 = new LinkedList<>();
        list3.add("Elemento1");
        list3.add("Elemento2");
        System.out.println("Lista original:");
        list3.printList();
        LinkedList<String> clonedList = (LinkedList<String>) list3.clone(); // Clona la lista
        System.out.println("Lista clonada:");
        clonedList.printList(); // Imprime la lista clonada
        list3.clear(); // Limpia la lista original
        System.out.println("Lista después de clear:");
        list3.printList();

        // -------------------Probando contains y descendingIterator----------------------------
        System.out.println("-------------------Probando contains y descendingIterator----------------------------");
        LinkedList<String> list4 = new LinkedList<>();
        list4.add("Elemento1");
        list4.add("Elemento2");
        System.out.println("Lista contiene 'Elemento1': " + list4.contains("Elemento1"));
        System.out.println("Lista contiene 'Elemento3': " + list4.contains("Elemento3"));
        System.out.println("Iterando en orden descendente:");
        Iterator<String> descendingIterator = list4.descendingIterator();
        while (descendingIterator.hasNext()) {
            System.out.println(descendingIterator.next());
        }

        // -------------------Probando insert y deleteByKey----------------------------
        System.out.println("-------------------Probando insert y deleteByKey----------------------------");
        LinkedList<String> list5 = new LinkedList<>();
        list5.add("Elemento1");
        list5.add("Elemento2");
        System.out.println("Lista original:");
        list5.printList();
        LinkedList.insert(list5, "Elemento3"); // Inserta "Elemento3"
        System.out.println("Lista después de insertar 'Elemento3':");
        list5.printList();
        LinkedList.deleteByKey(list5,"Elemento2"); // Elimina "Elemento2" de la lista
        System.out.println("Lista después de eliminar 'Elemento2':");
        list5.printList();

        // -------------------Probando deleteAtPosition y size----------------------------
        System.out.println("-------------------Probando deleteAtPosition y size----------------------------");
        LinkedList<String> list6 = new LinkedList<>();
        list6.add("Elemento1");
        list6.add("Elemento2");
        list6.add("Elemento3");
        System.out.println("Lista original:");
        list6.printList();
        LinkedList.deleteAtPosition(list6,1); // Elimina el elemento en la posición 1
        System.out.println("Lista después de eliminar el elemento en la posición 1:");
        list6.printList();
        System.out.println("Tamaño de la lista 6: " + list6.size()); 

        // -------------------Probando removeFirst y removeLast----------------------------
        System.out.println("-------------------Probando removeFirst y removeLast----------------------------");
        LinkedList<String> list7 = new LinkedList<>();
        list7.add("Elemento1");
        list7.add("Elemento2");
        list7.add("Elemento3");
        System.out.println("Lista original:");
        list7.printList();
        list7.removeFirst(); // Elimina el primer elemento
        System.out.println("Primer elemento eliminado: ");
        list7.printList();
        list7.removeLast(); // Elimina el último elemento
        System.out.println("Último elemento eliminado: ");
        list7.printList();
        System.out.println("Lista después de eliminar el primer y último elemento:");
        list7.printList();

    }    
}