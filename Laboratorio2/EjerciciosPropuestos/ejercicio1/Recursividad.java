package Laboratorio2.EjerciciosPropuestos.ejercicio1;

/*Invertir vector de enteros, permite ingresar tamaño y captura de valores del arreglo, el método
invertirArray calcula y muestra el resultado.
N = 3
A = [1 2 3] -> Asalida=[3 2 1]*/


public class Recursividad {
    public int[] invertirArray(int[] array, int i, int j) {
        if (i < j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            return invertirArray(array, i + 1, j - 1);
        }
        return array;
    }

    public static void main(String[] args) {

    }
}