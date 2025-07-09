package Laboratorio8.EjerciciosPropuestos.Ejercicio7;

import java.util.ArrayList;
import java.util.List;
// Esta clase representa un árbol B+ genérico
public class BPlusTree<T extends Comparable<T>>{
    private int t; // grado mínimo (t >= 2)
    private Node<T> root;

    public BPlusTree(int t) {
        if (t < 2) {
            throw new IllegalArgumentException("El grado mínimo debe ser al menos 2.");
        }
        this.t = t;
        this.root = new Node<>(true);  // Al principio la raíz es hoja
    }

    public Node<T> getRoot() {
        return root;
    }

    public void destroy() {
        root = null;  // Liberar la referencia a la raíz
    }

    public boolean isEmpty() {
        return root == null || (root.getKeys().isEmpty() && root.isLeaf());
    }

    public boolean search(T key) {
        if (isEmpty()) {
            return false;
        }
        return searchInNode(root, key);
    }
    private boolean searchInNode(Node<T> node, T key) {
        int i = 0;
        while (i < node.getNumberOfKeys() && key.compareTo(node.getKeys().get(i)) > 0) {
            i++;
        }
        if (i < node.getNumberOfKeys() && key.equals(node.getKeys().get(i))) {
            return true;  // Clave encontrada
        }
        if (node.isLeaf()) {
            return false;  // Clave no encontrada en una hoja
        }
        return searchInNode(node.getChild(i), key);  // Buscar en el hijo correspondiente
    }





}