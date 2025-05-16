package Laboratorio2.EjerciciosPropuestos.ejercicio2;
import java.util.Scanner;
/*
 * Rotar a la Izquierda, permite ingresar tamaño y captura de valores del arreglo, el método
 * rotarIzquierdaArray calcula y muestra el resultado.
 * Si d=2
 * A=[1 2 3 4 5] -> Ainvertido=[3 4 5 1 2]
 */
public class Recursividad {
    public int[] rotarIzquierdaArray(int[] A, int d){
        if (d == 0 || A.length == 0) {
        return A;
        }

        // Rotar una vez a la izquierda, osea caso base
        int[] rotado = new int[A.length];
        for (int i = 1; i < A.length; i++) {
            rotado[i - 1] = A[i];
        }
        rotado[A.length - 1] = A[0];

        // Llamada recursiva hasta que d sea 0, dependera del numero de veces que se quiera rotar
        return rotarIzquierdaArray(rotado, d - 1);

    }


    public static void main(String[] args) {
        
    }
}