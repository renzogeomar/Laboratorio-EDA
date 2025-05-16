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
        for(int i = 0 ; i < d; i++){
            int temp = A[0];
            for(int j = 0; j < A.length - 1; j++){
                A[j] = A[j + 1];
            }
            A[A.length - 1] = temp;
        }

    }


    public static void main(String[] args) {
        
    }
}