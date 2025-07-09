package Laboratorio8.EjerciciosPropuestos.Ejercicio4;

import java.util.ArrayList;
import java.util.List;

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

    public void setKeys(List<T> keys) {
        this.keys = new ArrayList<>(keys); 
    }

    public ArrayList<Node<T>> getChildren() {
        return children;
    }

    public void setChildren(List<Node<T>> children) {
        this.children = new ArrayList<>(children); 
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