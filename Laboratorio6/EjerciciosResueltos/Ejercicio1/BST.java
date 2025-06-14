package Laboratorio6.EjerciciosResueltos.Ejercicio1;

public class BST<T extends Comparable<T>>{
    private Node<T> root;

    public BST() {
        this.root = null;
    }
    public void destroy(){
        root = null; // Eliminar la referencia al nodo raíz
    }
    public boolean isEmpty() {
        return root == null; // Verifica si el árbol está vacío
    }
    public void insert(T data){
        Node<T> newNode = new Node<>(data);
        if (root == null) {
            root = newNode; // Si el árbol está vacío, el nuevo nodo se convierte en la raíz
        } 
        else {
            insertRec(root, newNode); // Inserta recursivamente
        }
    }
    public void insertRec(Node<T> actual, Node<T> newNode) {
        if (newNode.getData().compareTo(actual.getData()) < 0) { // devuelve un valor negativo si newNode es menor que actual, 0 si son iguales 
            //y un valor positivo si newNode es mayor que actual y positivo si newNode es mayor que actual
            // Si el nuevo dato es menor, va a la izquierda
            if (actual.getLeft() == null) { // Verifica si el hijo izquierdo es nulo
                actual.setLeft(newNode);
            } 
            else {
                insertRec(actual.getLeft(), newNode);
            }
        } 
        else {
            // Si el nuevo dato es mayor o igual, va a la derecha
            if (actual.getRight() == null) { // Verifica si el hijo derecho es nulo
                actual.setRight(newNode);
            } 
            else {
                insertRec(actual.getRight(), newNode);
            }
        }
    }



}