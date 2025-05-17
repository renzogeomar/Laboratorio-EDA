package Laboratorio2.EjerciciosPropuestos.ejercicio2;
import java.util.Scanner;
/* Ejercicio 2:
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
        Scanner scan = new Scanner(System.in);
        Recursividad re = new Recursividad();
        System.out.println("Ingrese el tamaño del arreglo:");
        int n = scan.nextInt();
        int[] A = new int[n];
        System.out.println("Ingrese los " + n + " elementos del arreglo:");
        for (int i = 0; i < n; i++) {
            A[i] = scan.nextInt();
        }
        System.out.println("Ingrese el número de posiciones a rotar a la izquierda:");
        int d = scan.nextInt();
        int[] rotado = re.rotarIzquierdaArray(A, d);
        System.out.print("Arreglo rotado a la izquierda: ");
        for (int num : rotado) {
            System.out.print(num + " ");
        }
        scan.close();
        
    }
}