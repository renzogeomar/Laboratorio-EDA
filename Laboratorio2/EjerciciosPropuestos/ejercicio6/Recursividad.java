package Laboratorio2.EjerciciosPropuestos.ejercicio6;
import java.util.Scanner;
/* Ejercicio 6
 * Triangulo recursivo 3. El método trianguloRecursivo3 calcula y muestra el resultado
 * Si b = 5
 * Salida:
    *****
    *   *
    *   *
    *   *
    *****
 */
public class Recursividad{
    public void cuadradoRecursivo(int base,int nivel){
        // Condición base: termina la recursión cuando ya se imprimieron todas las filas
        if (nivel > base) {
            return;
        }

        // Primera o última línea: llena de '*'
        if (nivel == 1 || nivel == base) {
            for (int i = 0; i < base; i++) {
                System.out.print("*");
            }
        } else {
            // Líneas intermedias: '*' al inicio y final, espacios en medio
            for (int i = 0; i < base; i++) {
                if (i == 0 || i == base - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
        }

        System.out.println();

        cuadradoRecursivo(base, nivel + 1);

    }
    public static void main(String[] args) {
        Recursividad re = new Recursividad();
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese la base del cuadrado: ");
        int base = scan.nextInt();
        System.out.println("Cuadrado recursivo:");
        re.cuadradoRecursivo(base, 1);
        scan.close();
    }
}