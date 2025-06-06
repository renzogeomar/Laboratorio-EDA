package Laboratorio5.EjerciciosPropuestos.Ejercicio3;

import java.util.Arrays;
import java.util.List;

public class ejercicio3 {
    public static void main(String[] args) {
        QueueList<Integer> queueList = new QueueList<>();
        queueList.enqueue(1);
        queueList.enqueue(2);
        queueList.enqueue(3);
        queueList.enqueue(4);
        queueList.enqueue(5);
        queueList.enqueue(6);
        queueList.enqueue(7);
        queueList.enqueue(8);
        queueList.enqueue(9);
        queueList.enqueue(10);
        queueList.printQueue();
        System.out.println("Frente: " + queueList.front());
        System.out.println("Final: " + queueList.back());
        System.out.println("Eliminando tope de la cola: " + queueList.front());
        queueList.dequeue(); // Elimina el elemento en el frente (1)
        queueList.printQueue();
        QueueList<String> queue = new QueueList<>();
        queue.add("uno");
        queue.add("dos");
        queue.add("tres");
        queueList.printQueue();
        List<String> moreElements = Arrays.asList("Cuatro", "Cinco", "Seis");
        System.out.println("\nProbando addAll:");
        queue.addAll(moreElements);
        queue.printQueue();
        System.out.println("Probando element(): ");
        System.out.println(queue.element()); // Verifica el elemento en el frente sin eliminarlo
        System.out.println("Probando destroyQueue:");
        queue.destroyQueue();
        if (queue.isEmpty()) {
            System.out.println("La cola está vacía.");
        } 
        else {
            System.out.println("La cola no está vacía.");
        }
        System.out.println("Probando clear:");
        queueList.clear();
        if (queueList.isEmpty()) {
            System.out.println("La cola está vacía.");
        } 
        else {
            System.out.println("La cola no está vacía.");
        }


    }
}
