package Laboratorio1.Ejercicio2;
import java.util.*;
public class ejercicio2{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresar hasta que numero desea hallar los números primos: ");
        int numeros = scan.nextInt();
        calcularNumerosPrimos(numeros);
        scan.close();
    }
    public static void calcularNumerosPrimos(int numeros){
        boolean[] primos = new boolean[numeros+1];
        for(int i=0; i<numeros;i++){
            primos[i]= true;
        }
        // Criba de Eratóstenes
        for (int i = 2; i * i <= numeros; i++) { // i*i : es el limite que hay entre numeros
            if (primos[i]) { // solo los numeros que sean true recorren el for
                for (int j = i * i; j <= numeros; j += i) { //  = i*i , se le va aumentando de j+i hasta que sea mayor que numeros 
                    primos[j] = false; // Marcamos múltiplos como no primos
                }
            }
        }
        // Imprimir los números primos
        System.out.println("Números primos hasta " + numeros + ":");
        for (int i = 2; i <= numeros; i++) {
            if (primos[i]) {
                System.out.print(i + " ");
            }
        }
    }
}


    
 