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
    public void insert(T key) {
        if (isEmpty()) {
            root = new Node<>(true);  // Crear una nueva raíz si el árbol está vacío
        }
        if (root.getNumberOfKeys() == 2 * t - 1) {
            Node<T> newRoot = new Node<>(false);  // Crear una nueva raíz no hoja
            newRoot.addChild(root);
            splitChild(newRoot, 0);
            root = newRoot;  // Actualizar la raíz
        }
        insertNonFull(root, key);
    }
    private void insertNonFull(Node<T> node, T key) {
        int i = node.getNumberOfKeys() - 1;
        if (node.isLeaf()) {
            // Insertar en una hoja
            while (i >= 0 && key.compareTo(node.getKeys().get(i)) < 0) {
                i--;
            }
            node.insertKeyAt(i + 1, key);  // Insertar la clave en la posición correcta
        } else {
            // Buscar el hijo adecuado para insertar
            while (i >= 0 && key.compareTo(node.getKeys().get(i)) < 0) {
                i--;
            }
            i++;
            Node<T> child = node.getChild(i);
            if (child.getNumberOfKeys() == 2 * t - 1) {
                splitChild(node, i);  // Dividir el hijo si está lleno
                if (key.compareTo(node.getKeys().get(i)) > 0) {
                    i++;  // Ajustar el índice si la clave es mayor que la nueva clave del padre
                }
            }
            insertNonFull(child, key);  // Insertar en el hijo adecuado
        }
    }
    private void splitChild(Node<T> parent, int index) {
        Node<T> fullChild = parent.getChild(index);
        Node<T> newChild = new Node<>(fullChild.isLeaf());
        
        // Mover la mitad de las claves al nuevo hijo
        for (int j = 0; j < t - 1; j++) {
            newChild.addKey(fullChild.getKeys().get(j + t));
        }
        
        // Si es una hoja, mover los enlaces
        if (fullChild.isLeaf()) {
            newChild.setNext(fullChild.getNext());
            fullChild.setNext(newChild);
            newChild.setPrev(fullChild);
        }
        
        // Actualizar el número de claves en el hijo lleno
        for (int j = t - 1; j < fullChild.getNumberOfKeys(); j++) {
            fullChild.removeKeyAt(t - 1);
        }
        
        // Insertar la nueva clave en el padre
        parent.insertKeyAt(index, fullChild.getKeys().get(t - 1));
        parent.addChild(newChild);
        
        // Ajustar los hijos del padre
        parent.insertChildAt(index + 1, newChild);
    }







}