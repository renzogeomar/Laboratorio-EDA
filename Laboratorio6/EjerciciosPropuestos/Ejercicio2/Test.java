package Laboratorio6.EjerciciosPropuestos.Ejercicio2;
import java.util.Scanner;
import java.util.ArrayList;

public class Test{
    public static void main(String[] args){
        BST<Integer> bst = new BST<>();
        ArrayList<Character> lista = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese una palabra: ");
        String palabra = scan.next();
        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            lista.add(letra); // Agrega la letra a la lista    
        }
        System.out.println("Lista de letras: " + lista);



    }
}