package Laboratorio4.EjerciciosPropuestos.Ejercicio5;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;
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
    public void clear() {
        head = null;
    }

    public Object clone() {
        LinkedList<E> newList = new LinkedList<>();
        Node<E> current = head;
        while (current != null) {
            newList.add(current.getData());
            current = current.getNext();
        }
        return newList;
    }

    public E contains(Object o) {
        Node<E> current = head;
        while (current != null) {
            if (current.getData().equals(o)) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }
    public Iterator<E> descendingIterator() {
        Stack<E> stack = new Stack<>();
        Node<E> current = head;
        while (current != null) {
            stack.push(current.getData());
            current = current.getNext();
        }
        return stack.iterator();
    }
    public static <E> LinkedList<E> insert(LinkedList<E> list, E data) {
        Node<E> newNode = new Node<>(data);
        newNode.setNext(null);

        if (list.head == null) {
            list.head = newNode;
        } else {
            Node<E> last = list.head;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(newNode);
        }

        return list;
    }
    public static <T> LinkedList<T> deleteByKey(LinkedList<T> list, T key) {
        Node<T> currNode = list.head;
        Node<T> prev = null;

        // CASO 1: El nodo cabeza tiene el dato a eliminar
        if (currNode != null && currNode.getData().equals(key)) {
            list.head = currNode.getNext(); // cambia la cabeza
            System.out.println(key + " found and deleted");
            return list;
        }

        // CASO 2: El dato está en otro nodo
        while (currNode != null && !currNode.getData().equals(key)) {
            prev = currNode;
            currNode = currNode.getNext();
        }

        // CASO 2 continuación: Si se encuentra el dato
        if (currNode != null) {
            prev.setNext(currNode.getNext()); // desvincula el nodo
            System.out.println(key + " found and deleted");
        }

        // CASO 3: No se encontró el dato
        if (currNode == null) {
            System.out.println(key + " not found");
        }

        return list;
    }

    

}