package Laboratorio4.EjerciciosPropuestos.Ejercicio1;

public class NodeDouble<E> {
    private E data;// Dato del nodo
    private NodeDouble<E> next; // Apunta al siguiente nodo
    private NodeDouble<E> prev; // Apunta al nodo anterior

    public NodeDouble(E data) {
        this.data = data;
        this.next = null; // Inicializa el siguiente nodo como nulo
        this.prev = null; // Inicializa el nodo anterior como nulo
    }
    
}
