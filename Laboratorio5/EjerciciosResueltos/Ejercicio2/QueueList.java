package Laboratorio5.EjerciciosResueltos.Ejercicio2;

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
    

}
