package Laboratorio4.EjerciciosPropuestos.Ejercicio5;

public class Node<E> {
    private E data;// Dato del nodo
    private Node<E> next; // Apunta al siguiente nodo

    public Node(E data) {
        this.data = data;
        this.next = null; // Inicializa el siguiente nodo como nulo
    }
    public E getData() {
        return data; // Retorna el dato del nodo
    }
    public void setData(E data) {
        this.data = data; // Establece el dato del nodo
    }
    public Node<E> getNext() {
        return next; // Retorna el siguiente nodo
    }
    public void setNext(Node<E> next) {
        this.next = next; // Establece el siguiente nodo
    }

}
