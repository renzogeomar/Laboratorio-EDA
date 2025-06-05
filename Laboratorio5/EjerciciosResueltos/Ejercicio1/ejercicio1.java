package Laboratorio5.EjerciciosResueltos.Ejercicio1;

public class ejercicio1 {
    public static void main(String[] args) {
        StackList<Integer> stack = new StackList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);

        System.out.println("Cima de la pila: " + stack.top()); // Debería imprimir 8
        stack.pop(); // Elimina el elemento en la cima (8)
        System.out.println("Cima de la pila: " + stack.top()); 
        stack.pop(); // Elimina el elemento en la cima (7)
        System.out.println("Cima de la pila: " + stack.top()); 
        stack.pop(); // Elimina el elemento en la cima (6)
        System.out.println("Cima de la pila: " + stack.top()); 
        stack.pop(); // Elimina el elemento en la cima (5)
        System.out.println("Cima de la pila: " + stack.top());
        stack.pop(); // Elimina el elemento en la cima (4)
        System.out.println("Cima de la pila: " + stack.top());
        stack.pop(); // Elimina el elemento en la cima (3)
        System.out.println("Cima de la pila: " + stack.top());
        stack.pop(); // Elimina el elemento en la cima (2)
        System.out.println("Cima de la pila: " + stack.top());
        stack.pop(); // Elimina el elemento en la cima (1)
        if(stack.isEmpty()) {
            System.out.println("La pila está vacía.");
        } 
        else {
            System.out.println("La pila no está vacía.");
        }


    }
}
