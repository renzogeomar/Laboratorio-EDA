package Laboratorio8.EjerciciosPropuestos.Ejercicio3;

import java.util.ArrayList;

public class Node<T extends Comparable<T>> {
    private ArrayList<T> keys; // Lista de claves
    private ArrayList<Node<T>> children; // Lista de hijos
    private boolean isLeaf;  // Indica si el nodo es una hoja

    public Node(boolean isLeaf) {
        this.isLeaf = isLeaf;
        this.keys = new ArrayList<>();
        this.children = new ArrayList<>();
    }
    public ArrayList<T> getKeys() {
        return keys;
    }

    public void setKeys(ArrayList<T> keys) {
        this.keys = keys;
    }

    public ArrayList<Node<T>> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Node<T>> children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public int getNumberOfKeys() {
        return keys.size();
    }

    public Node<T> getChild(int index) {
        return children.get(index);
    }

    public void addKey(T key) {
        keys.add(key);
    }

    public void addChild(Node<T> child) {
        children.add(child);
    }

    public void insertKeyAt(int index, T key) {
        keys.add(index, key);
    }

    public void insertChildAt(int index, Node<T> child) {
        children.add(index, child);
    }

    public void removeKeyAt(int index) {
        keys.remove(index);
    }

    public void removeChildAt(int index) {
        children.remove(index);
    }

}