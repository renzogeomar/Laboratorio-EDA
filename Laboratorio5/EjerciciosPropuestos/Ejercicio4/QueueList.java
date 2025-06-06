package Laboratorio5.EjerciciosPropuestos.Ejercicio4;

import java.util.Collection;

public class QueueList<E> {
    private Node<E> front; //Frente de la cola
    private Node<E> rear; //Final de la cola

    public QueueList(){
        this.front = null; // Inicialmente la cola esta vacia
        this.rear = null; // Inicialmente la cola esta vacia
    }

    public void enqueue(E element){
        Node<E> newNode = new Node<>(element); // Crea un nuevo nodo con el elemento
        if (rear == null) { // si la cola esta vacia
            front = newNode; // El nuevo nodo es tanto el frente como el final
            rear = newNode; // El nuevo nodo es tanto el frente como el final
        }
        else{
            rear.setNext(newNode); // El siguiente del nodo final es el nuevo nodo
            rear = newNode; // Actualiza el final a ser el nuevo nodo
        }
    }

    public void dequeue(){
        if (front == null){ //La cola esta vacia
            throw new IllegalStateException("Queue is empty");
        } 
        else {
            front = front.getNext(); // Actualiza el frente al siguiente nodo
            if (front == null) { // Si el frente se vuelve null, la cola esta vacia
                rear = null; // Actualiza el final a null
            }

        }
    }

    public void destroyQueue(){
        front = null; // Elimina la cola al establecer el frente a null
        rear = null; // Elimina la cola al establecer al final a null
    }

    public boolean isEmpty(){
        return front == null; // Retorna true si la cola esta vacia
    }

    public E front(){
        if (front == null){ // la cola esta vacia
            throw new IllegalStateException("Queue is empty");
        }
        else{
            return front.getData(); // Retorna el dato del nodo en el frente 
        }
    }

    public E back(){
        if (rear == null){ // la cola esta vacia
            throw new IllegalStateException("Queue is empty");
        }
        else{
            return rear.getData(); // Retorna el dato del nodo final
        }
    }

    public boolean add(E e) {
        if (e == null) {
            throw new NullPointerException("Element cannot be null");
        }
        try {
            enqueue(e);
            return true;
        } 
        catch (IllegalStateException ex) {
            throw new IllegalStateException("Queue is full", ex);
        }
    }
    public boolean addAll(Collection<? extends E> c) {
        if (c == null) {
            throw new NullPointerException("Collection cannot be null");
        }
        boolean modified = false;
        for (E element : c) {
            if (add(element)) {
                modified = true;
            }
        }
        return modified;
    }
    public void clear() {
        destroyQueue();
    }
    public E element() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.getData();
    }
    public void printQueue(){
        Node<E> current = front; // comienza desde el frente de la cola
        if (current == null){
            System.out.println("La cola está vacía."); // Si la cola está vacía, imprime un mensaje
            return; // Sale del método
        }
        while (current != null){ // Mientras haya nodos en la cola
            System.out.print(current.getData() + " "); // Imprime el dato del nodo actual
            if (current.getNext() != null) {
                System.out.print(" -> ");
            }
            current = current.getNext(); // Avanza al siguiente nodo
        }
        System.out.println(" <- Final");
    }
    

}
