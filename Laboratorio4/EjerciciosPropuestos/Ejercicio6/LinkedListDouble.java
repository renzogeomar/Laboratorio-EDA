package Laboratorio4.EjerciciosPropuestos.Ejercicio6;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
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
        } 
        else {
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
        } 
        else {
            tail.setNext(newNode); // Enlaza el nuevo nodo al final de la lista
            newNode.setPrev(tail); // Establece el nodo anterior del nuevo nodo
            tail = newNode; // Actualiza la cola a ser el nuevo nodo
        }
    }
    public void clear() {
        head = null; // Inicializa la lista vacía
        tail = null; // Inicializa la lista vacía
    }
    public Object clone() {
        LinkedListDouble<E> newList = new LinkedListDouble<>(); // Crea una nueva lista
        NodeDouble<E> current = head; // Apunta al primer nodo de la lista original
        while (current != null) {
            newList.add(current.getData()); // Agrega cada elemento a la nueva lista
            current = current.getNext(); // Avanza al siguiente nodo
        }
        return newList; // Retorna la nueva lista clonada
    }
    public E contains(Object o) {
        NodeDouble<E> current = head; // Apunta al primer nodo
        while (current != null) { // Recorre la lista hasta el final
            if (current.getData().equals(o)) { // Compara el dato del nodo con el objeto
                return current.getData(); // Si lo encuentra, retorna el dato
            }
            current = current.getNext(); // Avanza al siguiente nodo
        }
        return null; // Si no lo encuentra, retorna null
    }
    public Iterator<E> descendingIterator() {
        return new Iterator<E>() {
            private NodeDouble<E> current = tail; // Comienza desde el último nodo

            @Override
            public boolean hasNext() {
                return current != null; // Verifica si hay un nodo siguiente
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException(); // Lanza excepción si no hay siguiente
                }
                E data = current.getData(); // Obtiene el dato del nodo actual
                current = current.getPrev(); // Avanza al nodo anterior
                return data; // Retorna el dato
            }
        };
    }
}