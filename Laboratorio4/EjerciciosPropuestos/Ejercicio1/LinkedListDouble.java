package Laboratorio4.EjerciciosPropuestos.Ejercicio1;
import java.util.Collection;
public class LinkedListDouble<E>{
    private NodeDouble<E> head; // Apunta al primer nodo de la lista
    private NodeDouble<E> tail; // Apunta al último nodo de la lista

    public LinkedListDouble() {
        this.head = null; // Inicializa la lista vacía
        this.tail = null; // Inicializa la lista vacía
    }
    public void printList() {
        NodeDouble<E> current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println(); // Salto de línea al final
    }
    public void add(E data) {
        NodeDouble<E> newNode = new NodeDouble<>(data); // Crea un nuevo nodo
        if (head == null) {
            head = newNode; // Si la lista está vacía, el nuevo nodo es la cabeza
            tail = newNode; // El nuevo nodo también es la cola
        } 
        else{
            tail.setNext(newNode); // Enlaza el nuevo nodo al final de la lista
            newNode.setPrev(tail); // Establece el nodo anterior del nuevo nodo
            tail = newNode; // Actualiza la cola a ser el nuevo nodo
        }
    }
    public void add(E data, int posititon){
        NodeDouble<E> newNode = new NodeDouble<>(data); // Crea un nuevo nodo
        if (head == null){
            head = newNode; // Si la lista está vacía, el nuevo nodo es la cabeza
            tail = newNode; // El nuevo nodo también es la cola
        }
        else{
            NodeDouble<E> current = head; // Apunta al primer nodo
            for (int i = 0; i < posititon - 1 && current != null; i++) { // Recorre la lista hasta la posición deseada
                current = current.getNext(); // Avanza al siguiente nodo
            }
            if (current != null) {
                newNode.setNext(current.getNext()); // Enlaza el nuevo nodo al siguiente del nodo actual
                if (current.getNext() != null) {
                    current.getNext().setPrev(newNode); // Establece el nodo anterior del siguiente nodo
                }
                current.setNext(newNode); // Enlaza el nuevo nodo al final de la lista
                newNode.setPrev(current); // Establece el nodo anterior del nuevo nodo
                if (newNode.getNext() == null) {
                    tail = newNode; // Actualiza la cola si es necesario
                }
            }
        }
    }
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E data : c) {
            add(data); // Agrega cada elemento de la colección a la lista
            result = true; // Indica que se agregó al menos un elemento
        }
        return result;
    }
    public boolean addAll(int index, Collection<? extends E> c) {
        boolean result = false;
        for (E data : c) {
            add(data, index); // Agrega cada elemento de la colección a la lista
            result = true; // Indica que se agregó al menos un elemento
        }
        return result;   
    }
    public void addFirst(E data) {
        NodeDouble<E> newNode = new NodeDouble<>(data); // Crea un nuevo nodo
        if (head == null) {
            head = newNode; // Si la lista está vacía, el nuevo nodo es la cabeza
            tail = newNode; // El nuevo nodo también es la cola
        } else {
            newNode.setNext(head); // Enlaza el nuevo nodo al inicio de la lista
            head.setPrev(newNode); // Establece el nodo anterior del nodo actual
            head = newNode; // Actualiza la cabeza a ser el nuevo nodo
        }
    }
    public void addLast(E data) {
        NodeDouble<E> newNode = new NodeDouble<>(data); // Crea un nuevo nodo
        if (head == null) {
            head = newNode; // Si la lista está vacía, el nuevo nodo es la cabeza
            tail = newNode; // El nuevo nodo también es la cola
        } else {
            tail.setNext(newNode); // Enlaza el nuevo nodo al final de la lista
            newNode.setPrev(tail); // Establece el nodo anterior del nuevo nodo
            tail = newNode; // Actualiza la cola a ser el nuevo nodo
        }
    }
}