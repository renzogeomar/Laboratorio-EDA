package Laboratorio4.EjerciciosResueltos.Ejercicio4;

import java.io.*;

// Un programa java para implementar
// Una simple lista enlazada
public class LinkedList {
    Node head; // cabecera de la lista

    // Nodo de lista enlazada.
    // Esta clase interna se hace estática
    // para que main() pueda acceder a ella
    static class Node {
        int data;
        Node next;

        // Constructor
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // **************INSERCION**************
    // Método para insertar un nuevo nodo
    public static LinkedList insert(LinkedList list, int data) {
        // Crea un nuevo nodo con los datos dados
        Node new_node = new Node(data);
        new_node.next = null;

        // Si la lista enlazada está vacía,
        // entonces convierte el nuevo nodo en la cabeza
        if (list.head == null) {
            list.head = new_node;
        } else {
            // De lo contrario recorra hasta el último nodo
            // e inserte el nuevo nodo allí
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            // Inserta el nuevo nodo al último nodo
            last.next = new_node;
        }

        // Retorna la lista desde la cabeza
        return list;
    }

    // **************Recorrido**************
    // Metodo para imprimir la lista enlazada
    public static void printList(LinkedList list) {
        Node currNode = list.head;
        System.out.print("\nLinkedList: ");

        // Recorre la lista enlazada (LinkedList)
        while (currNode != null) {
            // Imprime el dato en el nodo actual
            System.out.print(currNode.data + " ");
            // Va al siguiente nodo
            currNode = currNode.next;
        }

        System.out.println("\n");
    }

    // **************BORRADO POR DATO**************
    // Metodo para eliminar un nodo en LinkedList por dato
    public static LinkedList deleteByKey(LinkedList list, int key) {
        // Aloja el nodo cabecera
        Node currNode = list.head, prev = null;

        //
        // CASO 1:
        // Si el nodo principal tiene el dato que se va a eliminar
        if (currNode != null && currNode.data == key) {
            list.head = currNode.next; // Changed head

            // Muetra el mensaje
            System.out.println(key + " found and deleted");

            // Retorna la lista actualizada
            return list;
        }

        //
        // CASO 2:
        // Si el dato está en otro lugar que no sea la cabecera
        //
        // Busca el dato para ser borrado,
        // realiza un seguimiento al nodo anterior
        // ya que es necesario cambiar currNode.next
        while (currNode != null && currNode.data != key) {
            // si currNode no tiene el dato
            // continua con el siguiente nodo
            prev = currNode;
            currNode = currNode.next;
        }

        // si el dato estuviera presente, sería el currNode
        // Por lo tanto, el currNode no debe ser nulo
        if (currNode != null) {
            // Desde que el dato está en currNode
            // Desenlaza currNode de la linked list
            prev.next = currNode.next;

            // muestra el mensaje
            System.out.println(key + " found and deleted");
        }

        //
        // CASO 3: El dato no está presente
        //
        // Si el dato no está presente en linked list
        // el nodo actual podría ser nulo
        if (currNode == null) {
            // Muestra el mensaje
            System.out.println(key + " not found");
        }

        // devuelve la lista
        return list;
    }

    // **************Borrado por posicion**************
    // Metodo para eliminar un nodo en la LinkedList por POSITION
    public static LinkedList deleteAtPosition(LinkedList list, int index) {
        // Guarda el nodo cabecera
        Node currNode = list.head, prev = null;

        //
        // CASE 1:
        // si el índice es 0, entonces el nodo principal debe ser
        // eliminado
        if (index == 0 && currNode != null) {
            list.head = currNode.next; // Cambia la cabecera

            // Muestra el mensaje
            System.out.println(index + " position element deleted");

            // Retorna la lista actualizada
            return list;
        }

        //
        // CASO 2:
        // Si el índice es mayor que 0 pero menor que el
        // tamaño de LinkedList
        //
        // El contador
        int counter = 0;

        // Conteo del índice a ser eliminado
        // seguimiento del nodo anterior
        // ya que es necesario cambiar currNode.next
        while (currNode != null) {
            if (counter == index) {
                // Dado el currNode es la posición requerida
                // se desenlaza currNode de la lista enlazada
                prev.next = currNode.next;

                // Muestra el mensaje
                System.out.println(index + " position element deleted");
                break;
            } else {
                // si la posición actual no es el indice
                // continua con el siguiente nodo
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }

        // Si se encontro el elemento en la posición, debería ser
        // el currNode Por lo tanto el currNode no debe ser
        // null
        // CASO 3: El dato no está presente
        //
        // Si el dato no está presente en linked list
        // el nodo actual podría ser nulo
        if (currNode == null) {
            // Muestra el mensaje
            System.out.println(index + " position element not found");
        }

        // devuelve la lista
        return list;
    }

    // **************Metodo principal**************
    // método para crear una simple lista enlazada con n nodos
    public static void main(String[] args) {
        /* Inicia con una lista vacia. */
        LinkedList list = new LinkedList();

        //
        // ******INSERCIÓN******
        //
        // Inserta los valores
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);

        // Imprime la LinkedList
        printList(list);

        //
        // ******Eliminación por dato ******
        //
        // Elimina el nodo con el valor 1
        // En el caso el dato 1 está en ***la cabeza***
        deleteByKey(list, 1);

        // Imprime la LinkedList
        printList(list);

        // Borramos el nodo con el valor 4
        // En este caso el dato esta presente ***en el medio***
        deleteByKey(list, 4);

        // Imprime la LinkedList
        printList(list);

        // Borrar el nodo con el valor 10
        // En este caso el dato esta ***no presente***
        deleteByKey(list, 10);

        // Imprime la LinkedList
        printList(list);

        //
        // ******BORRADO POR LA POSICIÓN ******
        //
        // Eliminar nodo en la posición 0
        // En este caso, la clave es ***la cabecera***
        deleteAtPosition(list, 0);

        // Imprime la LinkedList
        printList(list);

        // Eliminar nodo en la posición 2
        // En este caso, la clave está presente ***en el medio***
        deleteAtPosition(list, 2);

        // Imprime la LinkedList
        printList(list);

        // Eliminar el nodo en la posición 10
        // En este caso el dato esta ***no presente***
        deleteAtPosition(list, 10);

        // Imprime la LinkedList
        printList(list);
    }
}