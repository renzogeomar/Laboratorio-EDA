package Laboratorio5.EjerciciosResueltos.Ejercicio1;

public interface Stack<E>{
    boolean isEmpty();
    E top(); //cima
    void push(E element); //apilar
    void pop(); //desapilar
}
