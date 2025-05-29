package Laboratorio4.EjerciciosResueltos.Ejercicio6;

// Programa que demuestra la
// implementación de la LinkedList
// class
import java.util.*;

/*
 * Ejercicio 06: Crear una lista enlazada utilizando la librería java.util 
 * que implemente el añadido de elementos, de letras del abecedario de la A 
 * a la E y también el borrado de elementos, por posición , por
 * dato, que remueva el primero y el último.
 */
public class GFG {
    public static void main(String args[]) {
        // Creando el objeto de la
        // clase lista enlazada
        LinkedList<String> ll = new LinkedList<String>();

        // Añadido de elementos a la lista enlazada
        ll.add("A");
        ll.add("B");
        ll.addLast("C");
        ll.addFirst("D");
        ll.add(2, "E");

        System.out.println(ll);

        ll.remove("B");
        ll.remove(3);
        ll.removeFirst();
        ll.removeLast();

        System.out.println(ll);
    }
}