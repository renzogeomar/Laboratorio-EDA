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

    public boolean isEmpty() {
        return root.getNumberOfKeys() == 0;
    }

    public boolean search(T key){
        return search(root, key) != null;
    }

    private Node<T> search(Node<T> node, T key) {
        int i = 0;
        while (i < node.getNumberOfKeys() && key.compareTo(node.getKeys().get(i)) > 0) {
            i++;
        }
        if (i < node.getNumberOfKeys() && key.equals(node.getKeys().get(i))) {
            return node; // Clave encontrada
        } 
        else if (node.isLeaf()) {
            return null; // Clave no encontrada
        } 
        else {
            return search(node.getChild(i), key); // Buscar en el hijo correspondiente
        }
    }




}