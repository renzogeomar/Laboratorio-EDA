package Laboratorio4.EjerciciosPropuestos.Ejercicio2;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

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

        // -------------------Probando addFist y addLast----------------------------
        System.out.println("-------------------Probando addFist y addLast----------------------------");
        LinkedListCircular<String> list2 = new LinkedListCircular<>();
        // Agregar elementos al principio y al final de la lista
        list2.addFirst("Inicio");
        list2.add("prueba");
        list2.add("prueba2");
        list2.addLast("Final");
        list2.printList();

        // -------------------Probando clear y clone----------------------------
        System.out.println("-------------------Probando clear y clone----------------------------");
        LinkedListCircular<String> list3 = new LinkedListCircular<>();
        list3.add("Elemento1");
        list3.add("Elemento2");
        System.out.println("Lista original:");
        list3.printList();
        LinkedListCircular<String> clonedList = (LinkedListCircular<String>) list3.clone(); // Clona la lista
        System.out.println("Lista clonada:");
        clonedList.printList(); // Imprime la lista clonada
        list3.clear(); // Limpia la lista original
        System.out.println("Lista después de clear:");
        list3.printList(); // Imprime la lista original después de limpiar

        // -------------------Probando contains y descendingIterator----------------------------
        System.out.println("-------------------Probando contains y descendingIterator----------------------------");
        LinkedListCircular<String> list4 = new LinkedListCircular<>();
        list4.add("Elemento1");
        list4.add("Elemento2");
        System.out.println("Lista original:");
        list4.printList();
        System.out.println("¿Contiene 'Elemento1'? " + list4.contains("Elemento1")); // Verifica si contiene un elemento
        System.out.println("¿Contiene 'Elemento3'? " + list4.contains("Elemento3")); // Verifica si contiene un elemento no existente
        System.out.println("Iterando en orden inverso:");
        Iterator<String> it = list4.descendingIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        

    }
}
