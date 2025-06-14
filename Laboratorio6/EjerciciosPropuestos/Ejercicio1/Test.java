package Laboratorio6.EjerciciosPropuestos.Ejercicio1;

public class Test{
    public static void main(String[] args){
        BST<Integer> bst = new BST<>();

        // Insertar elementos
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.println("Árbol en formato estructurado:");
        bst.printPretty();

        // Recorridos
        System.out.println("\nRecorrido in-order (de menor a mayor):");
        bst.inOrder();

        System.out.println("\n\nRecorrido pre-order:");
        bst.preOrder();

        System.out.println("\n\nRecorrido post-order:");
        bst.postOrder();

        // Buscar elementos
        System.out.println("\n\nBuscar 40: " + bst.search(40));
        System.out.println("Buscar 100: " + bst.search(100));

        // Predecesor y sucesor
        System.out.println("\nPredecesor de 50: " + (bst.findPredecessor(50) != null ? bst.findPredecessor(50).getData() : "null"));
        System.out.println("Sucesor de 50: " + (bst.findSuccessor(50) != null ? bst.findSuccessor(50).getData() : "null"));

        // Eliminar nodo sin hijos
        System.out.println("\nEliminar 20 (sin hijos)");
        bst.remove(20);
        bst.printPretty();

        // Eliminar nodo con un hijo
        System.out.println("\nEliminar 30 (con un hijo)");
        bst.remove(30);
        bst.printPretty();

        // Eliminar nodo con dos hijos
        System.out.println("\nEliminar 50 (con dos hijos)");
        bst.remove(50);
        bst.printPretty();

        // Verificar si el árbol está vacío
        System.out.println("\n¿Árbol vacío?: " + bst.isEmpty());

        // Destruir árbol
        System.out.println("\nDestruyendo el árbol...");
        bst.destroy();
        System.out.println("¿Árbol vacío?: " + bst.isEmpty());
    }
}