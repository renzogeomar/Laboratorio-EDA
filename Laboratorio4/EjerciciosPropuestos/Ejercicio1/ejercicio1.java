package Laboratorio4.EjerciciosPropuestos.Ejercicio1;

public class ejercicio1 {
    public static void main(String[] args) {
        LinkedListDouble<Integer> listEnteros = new LinkedListDouble<>();
        LinkedListDouble<String> listCadenas = new LinkedListDouble<>();
        
        // Agregar elementos a la lista
        listEnteros.add(1);
        listEnteros.add(2);
        listEnteros.add(3);
        listCadenas.add("Hola");
        listCadenas.add("Mundo");
        
        // Agregar un elemento en una posición específica
        listEnteros.add(4, 2); 
        listCadenas.add("Java", 1);
        
        listEnteros.printList(); 
        listCadenas.printList();
    }    
}