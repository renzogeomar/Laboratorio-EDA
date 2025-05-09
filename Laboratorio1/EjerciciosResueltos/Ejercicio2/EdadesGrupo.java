package Laboratorio1.EjerciciosResueltos.Ejercicio2;
import java.util.*;
public class EdadesGrupo{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número natural N: ");
        int N = scanner.nextInt();
        // Validar que N sea positivo
        if (N <= 0) {
            System.out.println("Por favor, ingrese un número natural positivo.");
            return;
        }
        int suma = 0;
        int i = 1;
        // Calcular la suma usando un bucle while
        while (i <= N) {
            suma += i;
            i++;
        }
        // Mostrar el resultado
        System.out.println("La suma de los primeros " + N + " números naturales es: " + suma);
    }
}