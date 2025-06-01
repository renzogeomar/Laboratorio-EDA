package Laboratorio4.EjerciciosResueltos.Ejercicio11;

//import java.io.*;
import java.util.LinkedList;

/*
 * Ejercicio 11: Mostrar un programa en java que utilice
 * la librería java.util y muestre el uso del método size().
 */
public class GFG2 {
    public static void main(String args[]) {
        LinkedList<String> list = new LinkedList<String>();
        list.add("Uno, Dos, Tres ");
        list.add("Cuatro ");

        // Mostrar el tamaño de la lista
        System.out.println("El tamaño de la lista es: " + list.size());
    }
}