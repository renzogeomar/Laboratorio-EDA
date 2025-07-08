package Laboratorio8.EjerciciosPropuestos.Ejercicio3;
import java.io.IOException;
import java.io.PrintWriter;

public class BTree<T extends Comparable<T>>{
    private Node<T> root;
    private final int orden;

    public BTree(int orden) {
        if (orden < 2) throw new IllegalArgumentException("Orden mínimo t >= 2");
        this.orden = orden;
        this.root = new Node<>(true);
    }

    public void destroy(){
        root = new Node<>(true);
    }


}