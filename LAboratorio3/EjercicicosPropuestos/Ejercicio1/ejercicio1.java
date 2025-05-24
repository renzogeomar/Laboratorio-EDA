package LAboratorio3.EjercicicosPropuestos.Ejercicio1;
import java.util.*;
public class ejercicio1{
    public static void main(String[] args) {
        list<Integer> miLista = new list<>();

        // Test add
        miLista.add(10);
        miLista.add(20);
        miLista.add(30);
        System.out.println("Lista después de add: ");
        printList(miLista);

        // Test add con posición
        miLista.add(15, 1);
        System.out.println("Después de add(15, 1): ");
        printList(miLista);

        // Test addAll
        List<Integer> nuevos = Arrays.asList(40, 50);
        miLista.addAll(nuevos);
        System.out.println("Después de addAll: ");
        printList(miLista);

        // Test addAll con índice
        List<Integer> nuevos2 = Arrays.asList(5, 7);
        miLista.addAll(0, nuevos2);
        System.out.println("Después de addAll(0, [...]): ");
        printList(miLista);

        // Test contains
        System.out.println("¿Contiene 20? " + miLista.contains(20));
        System.out.println("¿Contiene 100? " + miLista.contains(100));

        // Test containsAll
        System.out.println("¿Contiene 10 y 20? " + miLista.containsAll(Arrays.asList(10, 20)));

        // Test equals
        list<Integer> otraLista = new list<>();
        otraLista.addAll(Arrays.asList(5, 7, 10, 15, 20, 30, 40, 50));
        System.out.println("¿Listas iguales? " + miLista.equals(otraLista));

        // Test get
        System.out.println("Elemento en posición 2: " + miLista.get(2));

        // Test indexOf y lastIndexOf
        miLista.add(10);
        System.out.println("Primera posición de 10: " + miLista.indexOf(10));
        System.out.println("Última posición de 10: " + miLista.lastIndexOf(10));

        // Test isEmpty y size
        System.out.println("¿Está vacía? " + miLista.isEmpty());
        System.out.println("Tamaño de la lista: " + miLista.size());

        // Test remove(index)
        System.out.println("Elemento eliminado en posición 1: " + miLista.remove(1));
        printList(miLista);

        // Test remove(Object)
        System.out.println("¿Se eliminó el 30? " + miLista.remove(Integer.valueOf(30)));
        printList(miLista);

        // Test removeAll
        System.out.println("¿Se eliminó alguno de [5, 40]? " + miLista.removeAll(Arrays.asList(5, 40)));
        printList(miLista);

        // Test set
        System.out.println("Reemplazando posición 0 con 100: " + miLista.set(0, 100));
        printList(miLista);

        // Test subList
        list<Integer> sub = miLista.subList(1, 3);
        System.out.println("Sublista de 1 a 3: ");
        printList(sub);

        // Test clear
        miLista.clear();
        System.out.println("Después de clear: ");
        printList(miLista);
        System.out.println("¿Está vacía después de clear? " + miLista.isEmpty());
    }
    public static <T> void printList(list<T> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(lista.get(i) + " ");
        }
        System.out.println();
    }
}