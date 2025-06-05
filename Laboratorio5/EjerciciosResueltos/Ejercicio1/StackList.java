package Laboratorio5.EjerciciosResueltos.Ejercicio1;

public class StackList<E> {
    private Node<E> top; // Cima de la pila

    public StackList(){
        this.top = null; // Inicialmente la pila esta vacia
    }

    public void push(E element){
        Node<E> newNode = new Node<>(element); // Crea un nuevo nodo con el elemento
        newNode.setNext(top); // El siguiente del nuevo nodo es el actual top
        top = newNode; // Actualiza el top a ser el nuevo nodo
    }
}
