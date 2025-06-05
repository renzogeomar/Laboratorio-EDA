package Laboratorio5.EjerciciosPropuestos.Ejercicio1;

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
        stack.push(9);
        stack.push(10);
        stack.printStack();
        System.out.println("El tope es: "+ stack.top());
        System.out.println("Retirando el tope actual...");
        stack.pop(); // Elimina el elemento en la cima (10)
        System.out.println("El nuevo tope es: " + stack.top());
        stack.printStack();
        System.out.println("Buscando el elemento 5 en la pila...");
        stack.printStack();
        Integer variable = stack.search(5);
        if (variable != null) {
            System.out.println("El elemento 5 se encuentra en la pila.");
        } 
        else {
            System.out.println("El elemento 5 no se encuentra en la pila.");
        }
        System.out.println("Destruyendo la pila...");
        stack.destroyStack();
        if(stack.isEmpty()) {
            System.out.println("La pila está vacía.");
        } 
        else {
            System.out.println("La pila no está vacía.");
        }
        /* 
        System.out.println("Cima de la pila: " + stack.top()); 
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
            */


    }
}
