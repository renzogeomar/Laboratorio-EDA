package Laboratorio4.EjerciciosResueltos.Ejercicio13;

//import java.io.*;
import java.util.LinkedList;

/*
 * Ejercicio 13: Mostrar un programa en java que utilice la 
 * librería java.util y muestre el uso del método removelast().
 */
public class GFG2 {
    public static void main(String args[]) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("LinkedList:" + list);

        // Remueve la cola usando removeLast()
        System.out.println("The last element is removed: " + list.removeLast());

        // Muestra la lista final
        System.out.println("Final LinkedList:" + list);

        // Remueve el último elemento usando removeLast()
        System.out.println("The last element is removed: " + list.removeLast());

        // Mostrando la lista final
        System.out.println("Final LinkedList:" + list);
    }
}