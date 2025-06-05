package Laboratorio5.EjerciciosPropuestos.Ejercicio2;

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

    public E search(Object o){
        Node<E> current = top; // Comienza desde la cima de la pila
        while (current != null) { // Mientras haya nodos en la pila
            if (o != null && o.equals(current.getData())){ // Compara el dato del nodo actual con el objeto O
                return current.getData(); // Retorna el dato si se encuentra
            }
            current = current.getNext(); // Avanza al siguiente nodo
        }
        return null; // Retorna null si no se encuentra el objeto O en la pila
    }

    public void printStack(){
        Node<E> current = top; // Comienza desde la cima de la pila
        while (current != null) { //Mientra haya nodos en la pila
            System.out.println(current.getData() + " "); // Imprime el dato del nodo actual
            current = current.getNext(); //Avanza al siguiente nodo
        }
    }
}
