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
}