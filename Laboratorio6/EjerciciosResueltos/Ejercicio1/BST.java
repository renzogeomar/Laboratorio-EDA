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
    public void remove(T data){
        root = removeRec(root, data); // Llama al método recursivo para eliminar el nodo
    }
    public Node<T> removeRec(Node<T> actual, T data){
        if (actual == null){
            return null; // Si el nodo actual es nulo, no hay nada que eliminar
        }
        if (data.compareTo(actual.getData()) < 0){
            // Si el dato a eliminar es menor, busca en el subárbol izquierdo
            actual.setLeft(removeRec(actual.getLeft(), data)); // Llama recursivamente al subárbol izquierdo
        }
        else if (data.compareTo(actual.getData()) > 0){
            // Si el dato a eliminar es mayor, busca en el subárbol derecho
            actual.setRight(removeRec(actual.getRight(), data)); // Llama recursivamente al subárbol derecho
        } 
        else {
            // Si el dato es igual al del nodo actual, se elimina este nodo
            if (actual.getLeft() == null && actual.getRight() == null) {
                return null; // Si no tiene hijos, simplemente devuelve nulo
            } 
            else if (actual.getRight() == null) {
                return actual.getLeft(); // Si no tiene hijo derecho, devuelve el hijo izquierdo
            }
            else if (actual.getLeft() == null) {
                return actual.getRight(); // Si no tiene hijo izquierdo, devuelve el hijo derecho
            }
            // Si tiene ambos hijos, encuentra el mínimo en el subárbol derecho
            Node<T> minNode = findMin(actual.getRight());
            actual.setData(minNode.getData()); // Reemplaza el dato del nodo actual con el mínimo encontrado
            actual.setRight(removeRec(actual.getRight(), minNode.getData())); // Elimina el mínimo encontrado del subárbol derecho
        }
        return actual; // Devuelve el nodo actual actualizado
    }
    public Node<T> findMin(Node<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft(); // Recorre hacia la izquierda hasta encontrar el nodo mínimo
        }
        return node; // Devuelve el nodo mínimo encontrado
    }
    public Node<T> findMax(Node<T> node){
        while (node.getRight() != null) {
            node = node.getRight(); // Recorre hacia la derecha hasta encontrar el nodo máximo
        }
        return node; // Devuelve el nodo máximo encontrado
    }
    public boolean search(T data) {
        return searchRec(root, data); // Llama al método recursivo para buscar el dato
    }
    public boolean searchRec(Node<T> actual, T data) {
        if (actual == null) {
            return false; // Si el nodo actual es nulo, el dato no se encuentra
        }
        if (data.compareTo(actual.getData()) < 0) {
            return searchRec(actual.getLeft(), data); // Busca en el subárbol izquierdo
        } 
        else if (data.compareTo(actual.getData()) > 0) {
            return searchRec(actual.getRight(), data); // Busca en el subárbol derecho
        } 
        else {
            return true; // Si el dato es igual al del nodo actual, se ha encontrado
        }
    }
    public Node<T> findPredecessor(T data) {
        Node<T> actual = root;
        Node<T> predecessor = null;

        while (actual != null) {
            if (data.compareTo(actual.getData()) < 0) {
                actual = actual.getLeft(); // Si el dato es menor, va al subárbol izquierdo
            } 
            else if (data.compareTo(actual.getData()) > 0) {
                predecessor = actual; // Actualiza el predecesor
                actual = actual.getRight(); // Va al subárbol derecho
            } 
            else {
                if (actual.getLeft() != null) {
                    predecessor = findMax(actual.getLeft()); // Encuentra el máximo en el subárbol izquierdo
                }
                break; // Sale del bucle si encuentra el nodo
            }
        }
        return predecessor; // Devuelve el predecesor encontrado
    }
    public Node<T> findSuccessor(T data) {
        Node<T> actual = root;
        Node<T> successor = null;

        while (actual != null) {
            if (data.compareTo(actual.getData()) < 0) {
                successor = actual; // Actualiza el sucesor
                actual = actual.getLeft(); // Va al subárbol izquierdo
            } 
            else if (data.compareTo(actual.getData()) > 0) {
                actual = actual.getRight(); // Si el dato es mayor, va al subárbol derecho
            } 
            else {
                if (actual.getRight() != null) {
                    successor = findMin(actual.getRight()); // Encuentra el mínimo en el subárbol derecho
                }
                break; // Sale del bucle si encuentra el nodo
            }
        }
        return successor; // Devuelve el sucesor encontrado
    }
    public void inOrder() {
        inOrderRec(root); // Llama al método recursivo para imprimir en orden
    }
    public void inOrderRec(Node<T> node) {
        if (node != null) {
            inOrderRec(node.getLeft()); // Recorre el subárbol izquierdo
            System.out.print(node.getData() + " "); // Imprime el dato del nodo actual
            inOrderRec(node.getRight()); // Recorre el subárbol derecho
        }
    }
    public void preOrder() {
        preOrderRec(root); // Llama al método recursivo para imprimir en preorden
    }
    public void preOrderRec(Node<T> node) {
        if (node != null) {
            System.out.print(node.getData() + " "); // Imprime el dato del nodo actual
            preOrderRec(node.getLeft()); // Recorre el subárbol izquierdo
            preOrderRec(node.getRight()); // Recorre el subárbol derecho
        }
    }



}