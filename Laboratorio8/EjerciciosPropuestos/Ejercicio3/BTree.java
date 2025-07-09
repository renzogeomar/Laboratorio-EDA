package Laboratorio8.EjerciciosPropuestos.Ejercicio3;

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
    
    public void remove(T key) {
        if (!search(key)) {
            return; // La clave no existe, no se puede eliminar
        }
        remove(root, key);
        if (root.getNumberOfKeys() == 0) { // Si la raíz queda vacía, hacer que sea una hoja
            root = root.isLeaf() ? new Node<>(true) : root.getChild(0);
        }
    }

    private void remove(Node<T> node, T key) {
        int i = 0;
        while (i < node.getNumberOfKeys() && key.compareTo(node.getKeys().get(i)) > 0) {
            i++;
        }
        if (i < node.getNumberOfKeys() && key.equals(node.getKeys().get(i))) { // Clave encontrada
            if (node.isLeaf()) { // Si es una hoja, eliminar la clave directamente
                node.removeKeyAt(i);
            } 
            else { // Si no es una hoja, manejar la eliminación de manera más compleja
                removeInternalNode(node, i);
            }
        } 
        else if (!node.isLeaf()) { // Si no es una hoja, buscar en el hijo correspondiente
            remove(node.getChild(i), key);
        }
    }

    private void removeInternalNode(Node<T> node, int index) {
        Node<T> child = node.getChild(index);
        if (child.getNumberOfKeys() >= orden) { // Si el hijo tiene suficientes claves, tomar la máxima del hijo
            T predecessor = getMax(child);
            node.getKeys().set(index, predecessor); // Reemplazar la clave con el predecesor
            remove(child, predecessor); // Eliminar el predecesor del hijo
        } 
        else {
            Node<T> sibling = node.getChild(index + 1);
            if (sibling.getNumberOfKeys() >= orden) { // Si el hermano tiene suficientes claves, tomar la mínima del hermano
                T successor = getMin(sibling);
                node.getKeys().set(index, successor); // Reemplazar la clave con el sucesor
                remove(sibling, successor); // Eliminar el sucesor del hermano
            } 
            else { // Si ambos hijos tienen menos de orden - 1 claves, fusionarlos
                merge(node, index);
                remove(child, node.getKeys().get(index)); // Eliminar la clave fusionada
            }
        }
    }
    private T getMax(Node<T> node) {
        while (!node.isLeaf()) {
            node = node.getChild(node.getNumberOfKeys() - 1); // Ir al hijo derecho
        }
        return node.getKeys().get(node.getNumberOfKeys() - 1); // Retornar la última clave
    }
    private T getMin(Node<T> node) {
        while (!node.isLeaf()) {
            node = node.getChild(0); // Ir al hijo izquierdo
        }
        return node.getKeys().get(0); // Retornar la primera clave
    }
    private void merge(Node<T> parent, int index) {
        Node<T> leftChild = parent.getChild(index);
        Node<T> rightChild = parent.getChild(index + 1);
        
        // Mover la clave del padre al hijo izquierdo
        leftChild.addKey(parent.getKeys().get(index));
        
        // Mover todas las claves del hijo derecho al hijo izquierdo
        for (T key : rightChild.getKeys()) {
            leftChild.addKey(key);
        }
        
        // Mover todos los hijos del hijo derecho al hijo izquierdo
        if (!leftChild.isLeaf()) {
            for (Node<T> child : rightChild.getChildren()) {
                leftChild.addChild(child);
            }
        }
        
        // Eliminar el hijo derecho y la clave del padre
        parent.removeKeyAt(index);
        parent.getChildren().remove(index + 1);
    }
    public T predecesor(T key) {
        Node<T> node = root;
        while (node != null) { // Recorrer el árbol
            int i = 0;
            while (i < node.getNumberOfKeys() && key.compareTo(node.getKeys().get(i)) > 0) { // Buscar la posición de la clave
                i++;
            }
            if (i < node.getNumberOfKeys() && key.equals(node.getKeys().get(i))) { // Clave encontrada
                if (!node.isLeaf()) { // Si no es una hoja, buscar el hijo izquierdo
                    return getMax(node.getChild(i)); // Retorna la clave más grande del hijo izquierdo
                } 
                else if (i > 0) { // Si es una hoja y hay claves anteriores
                    return node.getKeys().get(i - 1); // Retorna la clave anterior en el mismo nodo
                } 
                else { // Si es una hoja y no hay claves anteriores
                    return null; // No tiene predecesor
                }
            } 
            else if (node.isLeaf()) { // Si es una hoja y no se encontró la clave
                return null;
            } 
            else { // Si no se encontró la clave, continuar en el hijo correspondiente
                node = node.getChild(i);
            }
        }
        return null; // Clave no encontrada
    }
    public T sucesor(T key) {
        Node<T> node = root;
        while (node != null) {
            int i = 0;
            while (i < node.getNumberOfKeys() && key.compareTo(node.getKeys().get(i)) > 0) {
                i++;
            }
            if (i < node.getNumberOfKeys() && key.equals(node.getKeys().get(i))) { // Clave encontrada
                if (!node.isLeaf()) { // Si no es una hoja, buscar el hijo derecho
                    return getMin(node.getChild(i + 1)); // Retorna la clave más pequeña del hijo derecho
                } 
                else if (i < node.getNumberOfKeys() - 1) {
                    return node.getKeys().get(i + 1); // Retorna la clave siguiente en el mismo nodo
                } 
                else {
                    return null; // No tiene sucesor
                }
            } 
            else if (node.isLeaf()) { // Si es una hoja y no se encontró la clave
                return null;
            } 
            else { // Si no se encontró la clave, continuar en el hijo correspondiente
                node = node.getChild(i);
            }
        }
        return null; // Clave no encontrada
    }






}