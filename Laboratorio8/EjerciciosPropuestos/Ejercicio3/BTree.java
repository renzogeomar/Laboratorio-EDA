package Laboratorio8.EjerciciosPropuestos.Ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class BTree<T extends Comparable<T>>{
    private Node<T> root;
    private final int grado;  // grado máximo

    public BTree(int grado) {
        if (grado < 3) throw new IllegalArgumentException("Grado mínimo m >= 3");
        this.grado = grado;
        this.root = new Node<>(true);
    }

    public void destroy() {
        root = new Node<>(true);
    }

    public boolean isEmpty() {
        return root.getNumberOfKeys() == 0;
    }

    public boolean search(T key) {
        return search(root, key) != null;
    }

    private Node<T> search(Node<T> node, T key) {
        int i = 0;
        while (i < node.getNumberOfKeys() && key.compareTo(node.getKeys().get(i)) > 0) { // Buscar la posición de la clave
            i++;
        }
        if (i < node.getNumberOfKeys() && key.equals(node.getKeys().get(i))) { // Clave encontrada
            return node; // Clave encontrada
        } 
        else if (node.isLeaf()) { // Si es hoja y no se encontró la clave
            return null; // Clave no encontrada
        } 
        else { // Si no es hoja, buscar en el hijo correspondiente
            return search(node.getChild(i), key); // Buscar en el hijo correspondiente
        }
    }

    public void insert(T key) {
        if (search(key)) {
            return; // La clave ya existe, no se inserta
        }
        if (root.getNumberOfKeys() == grado - 1) { // Si el nodo raíz está lleno
            Node<T> newRoot = new Node<>(false); // Crear nuevo nodo raíz
            newRoot.addChild(root);
            splitChild(newRoot, 0);
            root = newRoot;
        }
        insertNonFull(root, key);
    }

    private void insertNonFull(Node<T> node, T key) { // Método auxiliar para insertar en un nodo que no está lleno
        int i = node.getNumberOfKeys() - 1; // Índice del último elemento
        if (node.isLeaf()) {
            while (i >= 0 && key.compareTo(node.getKeys().get(i)) < 0) { // Buscar la posición correcta para insertar la clave
                i--;
            }
            node.insertKeyAt(i + 1, key); // Insertar la clave en la posición correcta
        } 
        else {
            while (i >= 0 && key.compareTo(node.getKeys().get(i)) < 0) { // Buscar el hijo adecuado
                i--;
            }
            i++;
            if (node.getChild(i).getNumberOfKeys() == grado - 1) { // Si el hijo está lleno
                splitChild(node, i);
                if (key.compareTo(node.getKeys().get(i)) > 0) { // Si la clave es mayor que la clave del padre después de dividir
                    i++;
                }
            }
            insertNonFull(node.getChild(i), key); // Insertar en el hijo adecuado
        }
    }

    private void splitChild(Node<T> parent, int index) {
        Node<T> fullChild = parent.getChild(index);
        Node<T> newChild = new Node<>(fullChild.isLeaf());

        int mid = grado / 2;
        int totalKeys = fullChild.getNumberOfKeys();
        T medianKey = fullChild.getKeys().get(mid);

        // 📌 LOG: ver valores intermedios
        System.out.printf("=== SplitChild en index %d de nodo con claves %s%n", index, fullChild.getKeys());
        System.out.printf("TotalKeys=%d, mid=%d, median=%s%n", totalKeys, mid, medianKey);

        // Construir newChild
        for (int j = mid + 1; j < totalKeys; j++) {
            newChild.addKey(fullChild.getKeys().get(j));
        }
        if (!fullChild.isLeaf()) {
            for (int j = mid + 1; j <= totalKeys; j++) {
                newChild.addChild(fullChild.getChild(j));
            }
        }

        System.out.printf("newChild claves=%s%n", newChild.getKeys());

        // Ajustar fullChild
        List<T> leftKeys = new ArrayList<>();
        for (int j = 0; j < mid; j++) {
            leftKeys.add(fullChild.getKeys().get(j));
        }
        fullChild.setKeys(leftKeys);
        if (!fullChild.isLeaf()) {
            List<Node<T>> leftChildren = new ArrayList<>();
            for (int j = 0; j <= mid; j++) {
                leftChildren.add(fullChild.getChild(j));
            }
            fullChild.setChildren(leftChildren);
        }

        System.out.printf("leftChild ahora claves=%s%n", fullChild.getKeys());

        parent.insertKeyAt(index, medianKey);
        parent.insertChildAt(index + 1, newChild);
    }
    public void remove(T key) {
        if (!search(key)) { // Verificar si la clave existe antes de eliminar
            return; // La clave no existe, no se puede eliminar
        }
        remove(root, key); // Llamar al método auxiliar para eliminar la clave
        if (root.getNumberOfKeys() == 0) { // Si la raíz queda vacía, hacer que sea una hoja
            root = root.isLeaf() ? new Node<>(true) : root.getChild(0);
        }
    }

    private void remove(Node<T> node, T key) { // Método auxiliar para eliminar una clave
        int i = 0;
        while (i < node.getNumberOfKeys() && key.compareTo(node.getKeys().get(i)) > 0) { // Buscar la posición de la clave
            i++;
        }
        if (i < node.getNumberOfKeys() && key.equals(node.getKeys().get(i))) { // Clave encontrada
            if (node.isLeaf()) { // Si es hoja, eliminar la clave directamente
                node.removeKeyAt(i);
            } 
            else { // Si no es hoja, eliminar la clave del nodo interno
                removeInternalNode(node, i); // Si no es hoja, eliminar la clave del nodo interno
            }
        } 
        else if (!node.isLeaf()) { // Si no es hoja, buscar en el hijo correspondiente
            remove(node.getChild(i), key);
        }
    }
    private void removeInternalNode(Node<T> node, int index) { // Método auxiliar para eliminar una clave de un nodo interno
        Node<T> child = node.getChild(index); 
        int minKeys = (int) Math.ceil(grado / 2.0) - 1;

        if (child.getNumberOfKeys() >= minKeys + 1) {  // Si el hijo tiene suficientes claves, eliminar la clave directamente
            T predecessor = getMax(child);
            node.getKeys().set(index, predecessor);
            remove(child, predecessor);
        } 
        else {
            Node<T> sibling = node.getChild(index + 1);
            if (sibling.getNumberOfKeys() >= minKeys + 1) { // Si el hermano derecho tiene suficientes claves, tomar el sucesor
                T successor = getMin(sibling);
                node.getKeys().set(index, successor);
                remove(sibling, successor);
            } 
            else { // Si ambos hijos tienen menos de minKeys + 1 claves, fusionarlos
                merge(node, index);
                remove(child, node.getKeys().get(index));
            }
        }
    }

    private T getMax(Node<T> node) { // Método auxiliar para obtener el máximo de un nodo
        while (!node.isLeaf()) {
            node = node.getChild(node.getNumberOfKeys());
        }
        return node.getKeys().get(node.getNumberOfKeys() - 1);
    }

    private T getMin(Node<T> node) { // Método auxiliar para obtener el mínimo de un nodo
        while (!node.isLeaf()) {
            node = node.getChild(0);
        }
        return node.getKeys().get(0);
    }

    private void merge(Node<T> parent, int index) { // Método auxiliar para fusionar dos hijos
        Node<T> leftChild = parent.getChild(index);
        Node<T> rightChild = parent.getChild(index + 1);

        // Mover clave del padre al hijo izquierdo
        leftChild.addKey(parent.getKeys().get(index)); 

        // Mover claves del hijo derecho al izquierdo
        for (T key : rightChild.getKeys()) {
            leftChild.addKey(key);
        }

        // Mover hijos del derecho si no es hoja
        if (!leftChild.isLeaf()) {
            for (Node<T> child : rightChild.getChildren()) {
                leftChild.addChild(child);
            }
        }

        // Remover clave y hijo derecho del padre
        parent.removeKeyAt(index);
        parent.getChildren().remove(index + 1);
    }

    public T predecesor(T key) { // Método para obtener el predecesor de una clave
        Node<T> node = root;
        while (node != null) { // Recorrer el árbol
            int i = 0;
            while (i < node.getNumberOfKeys() && key.compareTo(node.getKeys().get(i)) > 0) { // Buscar la posición de la clave
                i++;
            }
            if (i < node.getNumberOfKeys() && key.equals(node.getKeys().get(i))) { // Clave encontrada
                if (!node.isLeaf()) { // Si no es hoja, buscar el máximo del hijo izquierdo
                    return getMax(node.getChild(i));
                } 
                else if (i > 0) { // Si es hoja, devolver el predecesor
                    return node.getKeys().get(i - 1);
                } 
                else { // Si es hoja y no hay predecesor
                    return null;
                }
            } 
            else if (node.isLeaf()) { // Si es hoja y no se encontró la clave
                return null;
            } 
            else { // Si no es hoja, continuar buscando en el hijo correspondiente
                node = node.getChild(i);
            }
        }
        return null;
    }

    public T sucesor(T key) { // Método para obtener el sucesor de una clave
        Node<T> node = root;
        while (node != null) { // Recorrer el árbol
            int i = 0;
            while (i < node.getNumberOfKeys() && key.compareTo(node.getKeys().get(i)) > 0) { // Buscar la posición de la clave
                i++;
            }
            if (i < node.getNumberOfKeys() && key.equals(node.getKeys().get(i))) { // Clave encontrada
                if (!node.isLeaf()) { // Si no es hoja, buscar el mínimo del hijo derecho
                    return getMin(node.getChild(i + 1));
                } 
                else if (i < node.getNumberOfKeys() - 1) { // Si es hoja, devolver el sucesor
                    return node.getKeys().get(i + 1);
                } 
                else { // Si es hoja y no hay sucesor
                    return null;
                }
            } 
            else if (node.isLeaf()) { // Si es hoja y no se encontró la clave
                return null;
            } 
            else { // Si no es hoja, continuar buscando en el hijo correspondiente
                node = node.getChild(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root, sb, 0);
        return sb.toString();
    }

    private void toString(Node<T> node, StringBuilder sb, int level) {
        if (node == null) return;
        for (int i = 0; i < level; i++) {
            sb.append("  ");
        }
        sb.append("Nivel ").append(level).append(": ");
        for (T key : node.getKeys()) {
            sb.append(key).append(" ");
        }
        sb.append("\n");
        if (!node.isLeaf()) {
            for (Node<T> child : node.getChildren()) {
                toString(child, sb, level + 1);
            }
        }
    }

    public String writeTree() {
        return writeTree(root);
    }

    private String writeTree(Node<T> current) {
        if (current == null) return "";

        StringBuilder sb = new StringBuilder();
        sb.append(current.getKeys()).append("\n");

        if (!current.isLeaf()) {
            for (Node<T> child : current.getChildren()) {
                sb.append(writeTree(child));
            }
        }

        return sb.toString();

    }


}