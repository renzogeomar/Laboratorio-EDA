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

    public void insert(T key) {
        if (search(key)) {
            return; // La clave ya existe, no se inserta
        }
        if (root.getNumberOfKeys() == 2 * orden - 1) { // Si el nodo raíz está lleno
            Node<T> newRoot = new Node<>(false); // Crear un nuevo nodo raíz
            newRoot.addChild(root); // Hacer que el nodo raíz sea un hijo del nuevo nodo raíz
            splitChild(newRoot, 0); // Dividir el nodo raíz lleno
            root = newRoot; // Actualizar la raíz del árbol
        }
        insertNonFull(root, key);
    }

    public void insertNonFull(Node<T> node, T key) { // Inserción en un nodo no lleno
        int i = node.getNumberOfKeys() - 1; // Índice del último elemento en el nodo
        if (node.isLeaf()) { // Si es una hoja, insertar la clave directamente
            while (i >= 0 && key.compareTo(node.getKeys().get(i)) < 0) { // Comparar la clave con las claves existentes
                i--;
            }
            node.insertKeyAt(i + 1, key); // Insertar la clave en la posición correcta
        } 
        else {
            while (i >= 0 && key.compareTo(node.getKeys().get(i)) < 0) { // Buscar el hijo adecuado para insertar la clave
                i--;
            }
            i++;
            if (node.getChild(i).getNumberOfKeys() == 2 * orden - 1) { // Si el hijo está lleno, dividirlo
                splitChild(node, i); // Dividir el hijo lleno
                if (key.compareTo(node.getKeys().get(i)) > 0) { // Si la clave es mayor que la clave del padre, ir al siguiente hijo
                    i++;
                }
            }
            insertNonFull(node.getChild(i), key); // Insertar la clave en el hijo adecuado
        }
    }
    private void splitChild(Node<T> parent, int index) {
        Node<T> fullChild = parent.getChild(index); // Obtener el hijo lleno
        Node<T> newChild = new Node<>(fullChild.isLeaf()); // Crear un nuevo hijo que será la mitad del hijo lleno
        
        // Mover la mitad de las claves al nuevo hijo
        for (int j = 0; j < orden - 1; j++) {
            newChild.addKey(fullChild.getKeys().get(j + orden));
        }
        
        // Si no es una hoja, mover los hijos correspondientes
        if (!fullChild.isLeaf()) {
            for (int j = 0; j < orden; j++) {
                newChild.addChild(fullChild.getChild(j + orden)); // Mover los hijos correspondientes al nuevo hijo
            }
        }
        
        // Reducir el número de claves en el hijo lleno
        fullChild.setKeys(fullChild.getKeys().subList(0, orden - 1));
        
        // Insertar el nuevo hijo en el padre
        parent.insertChildAt(index + 1, newChild);
        parent.insertKeyAt(index, fullChild.getKeys().get(orden - 1));
    }




}