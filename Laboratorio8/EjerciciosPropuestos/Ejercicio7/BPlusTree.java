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
        } 
        else {
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
    public void remove(T key) {
        if (isEmpty()) {
            return;  // No hay nada que eliminar
        }
        removeFromNode(root, key);
        if (root.getNumberOfKeys() == 0 && !root.isLeaf()) {
            root = root.getChild(0);  // Actualizar la raíz si está vacía
        }
    }
    private void removeFromNode(Node<T> node, T key) {
        int i = 0;
        while (i < node.getNumberOfKeys() && key.compareTo(node.getKeys().get(i)) > 0) {
            i++;
        }
        if (i < node.getNumberOfKeys() && key.equals(node.getKeys().get(i))) {
            // Clave encontrada
            if (node.isLeaf()) {
                node.removeKeyAt(i);  // Eliminar de una hoja
            } else {
                // Eliminar de un nodo interno
                Node<T> predecessor = getPredecessor(node, i);
                T predKey = predecessor.getKeys().get(predecessor.getNumberOfKeys() - 1);
                node.getKeys().set(i, predKey);  // Reemplazar con el predecesor
                removeFromNode(predecessor, predKey);  // Eliminar el predecesor
            }
        } 
        else if (!node.isLeaf()) {
            // Buscar en el hijo correspondiente
            Node<T> child = node.getChild(i);
            if (child.getNumberOfKeys() < t) {
                fillChild(node, i);  // Asegurar que el hijo tenga suficientes claves
            }
            removeFromNode(child, key);  // Continuar la eliminación en el hijo
        }
    }
    private Node<T> getPredecessor(Node<T> node, int index) {
        Node<T> current = node.getChild(index);
        while (!current.isLeaf()) {
            current = current.getChild(current.getNumberOfKeys() - 1);  // Ir al último hijo
        }
        return current;  // Retornar el último nodo hoja
    }
    private void fillChild(Node<T> parent, int index) {
        Node<T> child = parent.getChild(index);

        // Caso 1: El hermano izquierdo tiene suficientes claves
        if (index != 0 && parent.getChild(index - 1).getNumberOfKeys() >= t) {
            Node<T> leftSibling = parent.getChild(index - 1);

            // Mover clave del padre al hijo
            child.insertKeyAt(0, parent.getKeys().get(index - 1));

            // Mover la última clave del hermano izquierdo al padre
            parent.getKeys().set(index - 1, leftSibling.getKeys().get(leftSibling.getNumberOfKeys() - 1));
            leftSibling.removeKeyAt(leftSibling.getNumberOfKeys() - 1);

            // Si no es hoja, mover el último hijo del hermano izquierdo al hijo actual
            if (!leftSibling.isLeaf()) {
                child.insertChildAt(0, leftSibling.getChild(leftSibling.getChildren().size() - 1));
                leftSibling.removeChildAt(leftSibling.getChildren().size() - 1);
            }
        }

        // Caso 2: El hermano derecho tiene suficientes claves
        else if (index != parent.getNumberOfKeys() && parent.getChild(index + 1).getNumberOfKeys() >= t) {
            Node<T> rightSibling = parent.getChild(index + 1);

            // Mover clave del padre al hijo
            child.addKey(parent.getKeys().get(index));

            // Mover la primera clave del hermano derecho al padre
            parent.getKeys().set(index, rightSibling.getKeys().get(0));
            rightSibling.removeKeyAt(0);

            // Si no es hoja, mover el primer hijo del hermano derecho al hijo actual
            if (!rightSibling.isLeaf()) {
                child.addChild(rightSibling.getChild(0));
                rightSibling.removeChildAt(0);
            }
        }

        // Caso 3: Combinar con un hermano
        else {
            // Intentar combinar con el hermano derecho si existe
            if (index != parent.getNumberOfKeys()) {
                Node<T> rightSibling = parent.getChild(index + 1);

                // Mover clave del padre al hijo
                child.addKey(parent.getKeys().get(index));

                // Mover todas las claves del hermano derecho al hijo
                for (T key : rightSibling.getKeys()) {
                    child.addKey(key);
                }

                // Mover todos los hijos si no es hoja
                if (!child.isLeaf()) {
                    for (Node<T> grandChild : rightSibling.getChildren()) {
                        child.addChild(grandChild);
                    }
                }

                // Enlazar hojas
                if (child.isLeaf()) {
                    child.setNext(rightSibling.getNext());
                    if (rightSibling.getNext() != null) {
                        rightSibling.getNext().setPrev(child);
                    }
                }

                // Eliminar clave y puntero del padre
                parent.removeKeyAt(index);
                parent.removeChildAt(index + 1);
            } 
            
            // Sino, combinar con el hermano izquierdo
            else {
                Node<T> leftSibling = parent.getChild(index - 1);

                // Mover clave del padre al hermano izquierdo
                leftSibling.addKey(parent.getKeys().get(index - 1));

                // Mover todas las claves del hijo al hermano izquierdo
                for (T key : child.getKeys()) {
                    leftSibling.addKey(key);
                }

                // Mover todos los hijos si no es hoja
                if (!child.isLeaf()) {
                    for (Node<T> grandChild : child.getChildren()) {
                        leftSibling.addChild(grandChild);
                    }
                }

                // Enlazar hojas
                if (child.isLeaf()) {
                    leftSibling.setNext(child.getNext());
                    if (child.getNext() != null) {
                        child.getNext().setPrev(leftSibling);
                    }
                }

                // Eliminar clave y puntero del padre
                parent.removeKeyAt(index - 1);
                parent.removeChildAt(index);
            }
        }
    }
    public T predecesor(T key) {
        if (isEmpty()) {
            return null;  // Árbol vacío
        }
        return predecesorInNode(root, key);
    }
    private T predecesorInNode(Node<T> node, T key) {
        int i = 0;
        while (i < node.getNumberOfKeys() && key.compareTo(node.getKeys().get(i)) > 0) {
            i++;
        }
        if (i > 0 && node.isLeaf()) {
            return node.getKeys().get(i - 1);  // Predecesor en una hoja
        } 
        else if (!node.isLeaf()) {
            Node<T> child = node.getChild(i);
            if (child.getNumberOfKeys() > 0) {
                return predecesorInNode(child, key);  // Buscar en el hijo correspondiente
            } else if (i > 0) {
                return node.getKeys().get(i - 1);  // Predecesor en el padre
            }
        }
        return null;  // No se encontró predecesor
    }
    public T sucesor(T key) {
        if (isEmpty()) {
            return null;  // Árbol vacío
        }
        return sucesorInNode(root, key);
    }
    private T sucesorInNode(Node<T> node, T key) {
        int i = 0;
        while (i < node.getNumberOfKeys() && key.compareTo(node.getKeys().get(i)) >= 0) {
            i++;
        }
        if (i < node.getNumberOfKeys() && node.isLeaf()) {
            return node.getKeys().get(i);  // Sucesor en una hoja
        } 
        else if (!node.isLeaf()) {
            Node<T> child = node.getChild(i);
            if (child.getNumberOfKeys() > 0) {
                return sucesorInNode(child, key);  // Buscar en el hijo correspondiente
            } else if (i < node.getNumberOfKeys()) {
                return node.getKeys().get(i);  // Sucesor en el padre
            }
        }
        return null;  // No se encontró sucesor
    }

}
