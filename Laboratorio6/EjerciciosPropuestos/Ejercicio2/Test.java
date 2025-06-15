package Laboratorio6.EjerciciosPropuestos.Ejercicio2;
import java.util.Scanner;
import java.util.ArrayList;

public class Test{
    public static void main(String[] args){
        BST<Integer> bst = new BST<>();
        ArrayList<Character> lista = new ArrayList<>();
        ArrayList<Integer> listaASCII = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese una palabra: ");
        String palabra = scan.next();
        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            lista.add(letra); // Agrega la letra a la lista
            int ascii = (int) letra; // Convierte la letra a su valor ASCII
            listaASCII.add(ascii); // Agrega el valor ASCII a la lista    
            bst.insert(ascii); // Inserta el valor ASCII en el árbol BST
        }
        System.out.println("Lista de letras: " + listaASCII);
        System.out.println("Árbol BST creado con los valores ASCII de las letras.");
        bst.printPretty();
        scan.close();
    }
}