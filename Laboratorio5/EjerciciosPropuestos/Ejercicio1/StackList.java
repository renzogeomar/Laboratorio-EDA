package Laboratorio5.EjerciciosPropuestos.Ejercicio1;

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

    public E top(){
        if (top == null){
            throw new IllegalStateException("Stack is empty");
        } 
        else {
            return top.getData(); // Retorna el dato del nodo en la cima
        }
    }

    public void pop(){
        if (top == null){
            throw new IllegalStateException("Stack is empty");
        } 
        else {
            top = top.getNext(); // Actualiza el top al siguiente nodo
        }
    }

    public void destroyStack(){
        top = null; // Elimina la pila al establecer el top a null
    }

    public boolean isEmpty(){
        return top == null; // Retorna true si la pila esta vacia
    }
}
