package Laboratorio4.EjerciciosPropuestos.Ejercicio2;
import java.util.Collection;

public class LinkedListCircular<E> {
    private Node<E> head; // Apunta al primer nodo de la lista
    
    public LinkedListCircular() {
        this.head = null; // Inicializa la lista vacía
    }

    public void printList() {
        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        Node<E> current = head;
        do {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        } while (current != head);
        System.out.println(); // Salto de línea al final
    }
    public void add(E data) {
        Node<E> newNode = new Node<>(data); // Crea un nuevo nodo
        if (head == null) {
            head = newNode; // Si la lista está vacía, el nuevo nodo es la cabeza
            newNode.setNext(head); // El siguiente del nuevo nodo apunta a sí mismo
        } 
        else {
            Node<E> current = head;
            while (current.getNext() != head) { // Recorre hasta el último nodo
                current = current.getNext();
            }
            current.setNext(newNode); // Enlaza el nuevo nodo al final de la lista
            newNode.setNext(head); // El siguiente del nuevo nodo apunta a la cabeza
        }
    }
    public void add(E data, int position) {
        Node<E> newNode = new Node<>(data); // Crea un nuevo nodo
        if (head == null) {
            head = newNode; // Si la lista está vacía, el nuevo nodo es la cabeza
            newNode.setNext(head); // El siguiente del nuevo nodo apunta a sí mismo
        } 
        else {
            Node<E> current = head;
            for (int i = 0; i < position - 1 && current.getNext() != head; i++) { // Recorre hasta la posición deseada
                current = current.getNext();
            }
            newNode.setNext(current.getNext()); // Enlaza el nuevo nodo al siguiente del nodo actual
            current.setNext(newNode); // Enlaza el nuevo nodo al final de la lista
            if (newNode.getNext() == head) {
                head = newNode; // Actualiza la cabeza si es necesario
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
            add(data, index); // Agrega cada elemento de la colección a la lista en la posición especificada
            result = true; // Indica que se agregó al menos un elemento
        }
        return result;
    }
    public void addFirst(E data) {
        Node<E> newNode = new Node<>(data); // Crea un nuevo nodo
        if (head == null) {
            head = newNode; // Si la lista está vacía, el nuevo nodo es la cabeza
            newNode.setNext(head); // El siguiente del nuevo nodo apunta a sí mismo
        } 
        else {
            Node<E> current = head;
            while (current.getNext() != head) { // Recorre hasta el último nodo
                current = current.getNext();
            }
            newNode.setNext(head); // El siguiente del nuevo nodo apunta a la cabeza
            current.setNext(newNode); // Enlaza el nuevo nodo al final de la lista
            head = newNode; // Actualiza la cabeza a ser el nuevo nodo
        }
    }
    public void addLast(E data) {
        Node<E> newNode = new Node<>(data); // Crea un nuevo nodo
        if (head == null) {
            head = newNode; // Si la lista está vacía, el nuevo nodo es la cabeza
            newNode.setNext(head); // El siguiente del nuevo nodo apunta a sí mismo
        } 
        else {
            Node<E> current = head;
            while (current.getNext() != head) { // Recorre hasta el último nodo
                current = current.getNext();
            }
            current.setNext(newNode); // Enlaza el nuevo nodo al final de la lista
            newNode.setNext(head); // El siguiente del nuevo nodo apunta a la cabeza
        }
    }
    public void clear() {
        head = null; // Limpia la lista estableciendo la cabeza a null
    }
    public Object clone() {
        LinkedListCircular<E> clonedList = new LinkedListCircular<>();
        if (head == null) {
            return clonedList; // Retorna una lista vacía si la original está vacía
        }
        Node<E> current = head;
        do {
            clonedList.add(current.getData()); // Clona cada elemento de la lista original
            current = current.getNext();
        } while (current != head);
        return clonedList; // Retorna la lista clonada
    }

    
}
