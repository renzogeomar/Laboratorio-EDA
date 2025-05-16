package Laboratorio2.EjerciciosPropuestos.ejercicio5;
import java.util.Scanner;
/* Triangulo recursivo 3. El método trianguloRecursivo3 calcula y muestra el resultado
 * Si b = 5
 * Salida:
    *
   * *
  * * *
 * * * *
* * * * *

 */
public class Recursividad {
    public void trianguloRecursivo3(int base,int nivel) {
        if (nivel > base) {
            return;
        }
        // Imprimir espacios, con la ayuda del parametro nivel
        for (int i = 0; i < base - nivel; i++) {
            System.out.print(" ");
        }
        // Imprimir asteriscos
        for (int i = 0; i < nivel; i++) {
            System.out.print("* ");
        }
        System.out.println();
        // Llamada recursiva primero
        trianguloRecursivo3(base, nivel + 1);

    }
    public static void main(String[] args) {
        Recursividad re = new Recursividad();
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese la base del triángulo: ");
        int base = scan.nextInt();
        System.out.println("Triángulo recursivo alineado a la derecha:");
        re.trianguloRecursivo3(base, 1);

        scan.close();

    }
}    