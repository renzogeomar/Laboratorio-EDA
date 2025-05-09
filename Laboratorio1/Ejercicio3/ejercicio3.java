package Laboratorio1.Ejercicio3;
import java.util.*;
public class ejercicio3 {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        System.out.println("Ingresar cantidad de numeros");
        int cantidad= scan.nextInt();
        ArrayList<Integer> numeros= new ArrayList<>();
        for(int i=0; i<cantidad; i++){
            int numero= scan.nextInt();
            numeros.add(numero);
        }
        System.out.println("Lista original:");
        imprimir(numeros);
        
        ordenamientoInserccion(numeros);

        System.out.println("Lista ordenada:");
        imprimir(numeros);  

    }
    public static void ordenamientoInserccion(ArrayList<Integer> numeros){
        for(int i=1; i<numeros.size(); i++){
            int key= numeros.get(i);
            int j = i-1;
            while(j>=0 && numeros.get(j)>key){
                numeros.set(j+1, numeros.get(j));
                j--;
            }
            numeros.set(j+1, key);
        }
    }
    public static void imprimir(ArrayList<Integer> numeros){
        for(int i=0; i<numeros.size(); i++){
            System.out.println(numeros.get(i));
        }
    }
}