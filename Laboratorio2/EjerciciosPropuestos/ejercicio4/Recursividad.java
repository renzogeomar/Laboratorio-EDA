package Laboratorio2.EjerciciosPropuestos.ejercicio4;
import java.util.Scanner;
/* Triangulo recursivo 2. El método trianguloRecursivo2 calcula y muestra el resultado
 * Si b = 5
 * Salida:
    *
   **
  ***
 ****
*****
 */
public class Recursividad {
    public void trianguloRecursivo2(int base,int nivel) {
        if (nivel > base) {
            return;
        }
        // Llamada recursiva primero
        trianguloRecursivo2(base, nivel + 1);
        // Imprimir espacios, con la ayuda del parametro nivel
        for (int i = 0; i < base - nivel; i++) {
            System.out.print(" ");
        }
        // Imprimir asteriscos
        for (int i = 0; i < nivel; i++) {
            System.out.print("*");
        }
        System.out.println();

    }
    public static void main(String[] args) {
        Recursividad re = new Recursividad();
        Scanner scan = new Scanner(System.in);

        scan.close();

    }
}    