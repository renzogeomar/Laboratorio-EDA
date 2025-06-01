package Laboratorio4.EjerciciosPropuestos.Ejercicio6;

public class NodeDouble<E> {
    private E data;// Dato del nodo
    private NodeDouble<E> next; // Apunta al siguiente nodo
    private NodeDouble<E> prev; // Apunta al nodo anterior

    public NodeDouble(E data) {
        this.data = data;
        this.next = null; // Inicializa el siguiente nodo como nulo
        this.prev = null; // Inicializa el nodo anterior como nulo
    }
    public E getData() {
        return data; // Retorna el dato del nodo
    }
    public void setData(E data) {
        this.data = data; // Establece el dato del nodo
    }
    public NodeDouble<E> getNext() {
        return next; // Retorna el siguiente nodo
    }
    public void setNext(NodeDouble<E> next) {
        this.next = next; // Establece el siguiente nodo
    }
    public NodeDouble<E> getPrev() {
        return prev; // Retorna el nodo anterior
    }
    public void setPrev(NodeDouble<E> prev) {
        this.prev = prev; // Establece el nodo anterior
    }
    
}
