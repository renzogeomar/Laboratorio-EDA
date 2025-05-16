package Laboratorio2.EjerciciosPropuestos.ejercicio1;
import java.util.Scanner;
/*Invertir vector de enteros, permite ingresar tamaño y captura de valores del arreglo, el método
invertirArray calcula y muestra el resultado.
N = 3
A = [1 2 3] -> Asalida=[3 2 1]*/


public class Recursividad {
    public int[] invertirArray(int[] array, int inicio, int fin) {
        int [] resultado = new int[array.length];
        if (inicio < fin) {
            int temp = array[inicio];
            array[inicio] = array[fin];
            array[fin] = temp;
            return invertirArray(array, inicio + 1, fin - 1);
        }
        for (int i = 0; i < array.length; i++) {
            resultado[i] = array[i];
        }
        return resultado;
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
        re.invertirArray(A, 0, n - 1);
        System.out.print("Arreglo invertido (recursivo): ");
        for (int num : A) {
            System.out.print(num + " ");
        }
        scan.close();
    }
}