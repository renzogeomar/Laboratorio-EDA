package Laboratorio5.EjerciciosPropuestos.Ejercicio4;

public class ejercicio4 {
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
        System.out.println("frente: "+ queueList.front());
        System.out.println("final: "+ queueList.back());
        System.out.println("Tope de la cola: " + queueList.front());
        queueList.dequeue(); // Elimina el elemento en el frente (1)
        System.out.println("Tope de la cola: " + queueList.front());
        queueList.dequeue(); // Elimina el elemento en el frente (2)
        System.out.println("Tope de la cola: " + queueList.front());
        queueList.dequeue(); // Elimina el elemento en el frente (3)
        System.out.println("Tope de la cola: " + queueList.front());
        queueList.dequeue(); // Elimina el elemento en el frente (4)
        System.out.println("Tope de la cola: " + queueList.front());
        queueList.dequeue(); // Elimina el elemento en el frente (5)
        System.out.println("Tope de la cola: " + queueList.front());
        queueList.dequeue(); // Elimina el elemento en el frente (6)
        System.out.println("Tope de la cola: " + queueList.front());
        queueList.dequeue(); // Elimina el elemento en el frente (7)
        System.out.println("Tope de la cola: " + queueList.front());
        queueList.dequeue(); // Elimina el elemento en el frente (8)
        if(queueList.isEmpty()) {
            System.out.println("La cola está vacía.");
        } 
        else {
            System.out.println("La cola no está vacía.");
        }


    }
}
