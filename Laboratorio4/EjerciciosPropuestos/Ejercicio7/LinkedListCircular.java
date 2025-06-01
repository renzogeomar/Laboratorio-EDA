package Laboratorio4.EjerciciosPropuestos.Ejercicio7;
import java.util.Collection;
//import java.util.Iterator;

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
    public boolean contains(Object o) {
        if (head == null) {
            return false; // Retorna false si la lista está vacía
        }
        Node<E> current = head;
        do {
            if (current.getData().equals(o)) {
                return true; // Retorna true si encuentra el elemento
            }
            current = current.getNext();
        } while (current != head);
        return false; // Retorna false si no encuentra el elemento
    }

    public E element() {
        if (head == null) {
            throw new IllegalStateException("La lista está vacía."); // Lanza una excepción si la lista está vacía
        }
        return head.getData(); // Retorna el dato del primer nodo
    }
    public E get(int index) {
        if (head == null) {
            throw new IndexOutOfBoundsException("La lista está vacía."); // Lanza una excepción si la lista está vacía
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext(); // Avanza al siguiente nodo
            if (current == head) {
                throw new IndexOutOfBoundsException("Índice fuera de rango."); // Lanza una excepción si el índice es inválido
            }
        }
        return current.getData(); // Retorna el dato del nodo en la posición especificada
    }

    public void insert(E data) {
        Node<E> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            newNode.setNext(head);
        } else {
            Node<E> current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            current.setNext(newNode);
            newNode.setNext(head);
        }
    }

    public boolean deleteByKey(E key) {
        if (head == null) return false;

        Node<E> current = head;
        Node<E> prev = null;

        do {
            if (current.getData().equals(key)) {
                if (prev == null) { // Eliminar cabeza
                    // Si solo hay un nodo
                    if (current.getNext() == head) {
                        head = null;
                    } else {
                        // Buscar último nodo para actualizar su next
                        Node<E> last = head;
                        while (last.getNext() != head) {
                            last = last.getNext();
                        }
                        head = head.getNext();
                        last.setNext(head);
                    }
                } else {
                    prev.setNext(current.getNext());
                }
                return true; // eliminado exitosamente
            }
            prev = current;
            current = current.getNext();
        } while (current != head);

        return false; // no encontrado
    }

    public boolean deleteAtPosition(int index) {
        if (head == null || index < 0) return false;

        Node<E> current = head;
        Node<E> prev = null;
        int count = 0;

        do {
            if (count == index) {
                if (prev == null) { // eliminar cabeza
                    // Si solo hay un nodo
                    if (current.getNext() == head) {
                        head = null;
                    } else {
                        Node<E> last = head;
                        while (last.getNext() != head) {
                            last = last.getNext();
                        }
                        head = head.getNext();
                        last.setNext(head);
                    }
                } else {
                    prev.setNext(current.getNext());
                }
                return true;
            }
            prev = current;
            current = current.getNext();
            count++;
        } while (current != head);

        return false; 
    }

    public int size() {
        if (head == null) return 0;
        int count = 0;
        Node<E> current = head;
        do {
            count++;
            current = current.getNext();
        } while (current != head);
        return count;
    }

    public boolean removeFirst() {
        if (head == null) return false;

        // Si solo hay un nodo
        if (head.getNext() == head) {
            head = null;
            return true;
        }

        // Buscar último nodo para actualizar su next
        Node<E> last = head;
        while (last.getNext() != head) {
            last = last.getNext();
        }
        head = head.getNext();
        last.setNext(head);
        return true;
    }

    public boolean removeLast() {
        if (head == null) return false;

        // Si solo hay un nodo
        if (head.getNext() == head) {
            head = null;
            return true;
        }

        Node<E> current = head;
        Node<E> prev = null;

        while (current.getNext() != head) {
            prev = current;
            current = current.getNext();
        }

        // 'current' es el último nodo, 'prev' es penúltimo
        prev.setNext(head);
        return true;
    }
    
}
