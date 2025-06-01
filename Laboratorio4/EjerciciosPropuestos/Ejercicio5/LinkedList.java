package Laboratorio4.EjerciciosPropuestos.Ejercicio5;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class LinkedList<E>{
    private Node<E> head;
    public LinkedList() {
        this.head = null;
    }
    public void printList() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public void add(E data, int position) {
        Node<E> newNode = new Node<>(data);
        if (position <= 0 || head == null) {
            newNode.setNext(head);
            head = newNode;
            return;
        }

        Node<E> current = head;
        for (int i = 0; i < position - 1 && current.getNext() != null; i++) {
            current = current.getNext();
        }

        newNode.setNext(current.getNext());
        current.setNext(newNode);
    }
    public boolean addAll(Collection<? extends E> c) {
        boolean added = false;
        for (E item : c) {
            add(item);
            added = true;
        }
        return added;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        int pos = index;
        for (E item : c) {
            add(item, pos++);
        }
        return !c.isEmpty();
    }
    public void addFirst(E data) {
        Node<E> newNode = new Node<>(data);
        newNode.setNext(head);
        head = newNode;
    }

    public void addLast(E data) {
        add(data);
    }
}