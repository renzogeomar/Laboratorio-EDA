package Laboratorio2.EjerciciosPropuestos.ejercicio6;
import java.util.Scanner;
/* Triangulo recursivo 3. El método trianguloRecursivo3 calcula y muestra el resultado
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
        if(nivel % 2 == 0){
            System.out.println(" ");
            cuadradoRecursivo(base, nivel+1);
        }
        else if(nivel == base || nivel == 1){
            for(int i = 0; i < base; i++){
                System.out.print("*");
            }
            System.out.println(" ");
            cuadradoRecursivo(base, nivel+1);
        }
        else{
            for(int i = 0; i < base; i++){
                if(i == 0 || i == base-1){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println(" ");
            cuadradoRecursivo(base, nivel+1);
        }

    }
    public static void main(String[] args) {
    
    }
}