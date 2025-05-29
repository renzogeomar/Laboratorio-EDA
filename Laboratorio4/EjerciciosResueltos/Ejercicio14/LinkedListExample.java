package Laboratorio4.EjerciciosResueltos.Ejercicio14;

import java.util.LinkedList;

/*
 * Ejercicio 14: Mostrar un programa en java que utilice la 
 * librería java.util y muestre el uso del método addFirst() 
 * y addLast().
 */
public class LinkedListExample {
    public static void main(String[] args) {
        // Crea una nueva linked list
        LinkedList<Integer> linkedList = new LinkedList<>();

        // Añade elementos a la lista enlazada
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        // Añade un elemento al principio de la lista enlazada
        linkedList.addFirst(0);

        // Añade un elemento al final de la lista enlazada
        linkedList.addLast(4);

        // Imprime los elementos de la lista enlazada
        for (int i : linkedList) {
            System.out.println(i);
        }
    }
}

