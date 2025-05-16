package Laboratorio2.EjerciciosPropuestos.ejercicio3;
import java.util.Scanner;
/* Triangulo recursivo 1. El método trianguloRecursivo1 calcula y muestra el resultado
 * Si b = 5
 * Salida:
*
**
***
****
*****
 */
public class Recursividad {
    public void trianguloRecursivo(int base) {
        for(int i=0; i < base; i++){
            System.out.print("*");
        }
        System.out.println();
        if (base > 1) {
            trianguloRecursivo(base - 1);
        }


    }
    public static void main(String[] args) {
        Recursividad re = new Recursividad();
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese la base del triángulo:");
        int base = scan.nextInt();
        System.out.println("Triángulo recursivo:");
        re.trianguloRecursivo(base);

    }
}    