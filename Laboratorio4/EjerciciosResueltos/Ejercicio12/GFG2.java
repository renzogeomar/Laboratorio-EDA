package Laboratorio4.EjerciciosResueltos.Ejercicio12;

import java.io.*;
import java.util.LinkedList;

public class GFG2 {
    public static void main(String args[]) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("LinkedList:" + list);
        System.out.println("El primer elemento removido es: " + list.removeFirst());

        // Mostrando la lista final
        System.out.println("Final LinkedList:" + list);
    }
}
