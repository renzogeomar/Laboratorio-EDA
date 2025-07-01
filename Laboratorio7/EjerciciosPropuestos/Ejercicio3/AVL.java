package Laboratorio7.EjerciciosPropuestos.Ejercicio3;
import java.io.IOException;
import java.io.PrintWriter;

public class AVL<T extends Comparable<T>>{
    private Node<T> root;

    public AVL() {
        this.root = null;
    }
    public void destroy(){
        root = null; // Eliminar la referencia al nodo raíz
    }
    public boolean isEmpty() {
        return root == null; // Verifica si el árbol está vacío
    }
    public void insert(T data){
        root = insertRec(root, data); // Inserta recursivamente
    }
    public Node<T> insertRec(Node<T> actual, T data) {
        if (actual == null) {
            return new Node<>(data); // Si el nodo actual es nulo, crea un nuevo nodo
        }

        // Inserción estándar de BST
        if (data.compareTo(actual.getData()) < 0) {
            actual.setLeft(insertRec(actual.getLeft(), data)); // Inserta en el subárbol izquierdo
        } 
        else if (data.compareTo(actual.getData()) > 0) {
            actual.setRight(insertRec(actual.getRight(), data)); // Inserta en el subárbol derecho
        } 
        else {
            // Duplicados no permitidos en AVL
            return actual;
        }

        // Actualizar la altura del nodo actual
        actual.setHeight(1 + Math.max(getHeight(actual.getLeft()), getHeight(actual.getRight())));

        // Obtener el balance del nodo actual
        int balance = getBalance(actual);

        // Casos de desbalance:

        // Caso Izquierda-Izquierda
        if (balance > 1 && data.compareTo(actual.getLeft().getData()) < 0) {
            return simpleRightRotation(actual); // Rotación simple derecha
        }

        // Caso Derecha-Derecha
        if (balance < -1 && data.compareTo(actual.getRight().getData()) > 0) {
            return simpleLeftRotation(actual); // Rotación simple izquierda
        }

        // Caso Izquierda-Derecha
        if (balance > 1 && data.compareTo(actual.getLeft().getData()) > 0) {
            actual.setLeft(simpleLeftRotation(actual.getLeft())); 
            return simpleRightRotation(actual); // Rotación doble derecha-izquierda
        }

        // Caso Derecha-Izquierda
        if (balance < -1 && data.compareTo(actual.getRight().getData()) < 0) {
            actual.setRight(simpleRightRotation(actual.getRight()));
            return simpleLeftRotation(actual); // Rotación doble izquierda-derecha
        }

        return actual; // Nodo sin cambios
    }
    public void remove(T data){
        root = removeRec(root, data); // Llama al método recursivo para eliminar el nodo
    }
    public Node<T> removeRec(Node<T> actual, T data){
        if (actual == null) return null;

        if (data.compareTo(actual.getData()) < 0) {
            actual.setLeft(removeRec(actual.getLeft(), data));
        } 
        else if (data.compareTo(actual.getData()) > 0) {
            actual.setRight(removeRec(actual.getRight(), data));
        } 
        else {
            // Nodo encontrado
            if (actual.getLeft() == null || actual.getRight() == null) {
                Node<T> temp = (actual.getLeft() != null) ? actual.getLeft() : actual.getRight();
                if (temp == null) return null; // Sin hijos
                return temp; // Un hijo
            } 
            else {
                // Dos hijos
                Node<T> minNode = findMin(actual.getRight());
                actual.setData(minNode.getData());
                actual.setRight(removeRec(actual.getRight(), minNode.getData()));
            }
        }

        // Actualiza la altura
        actual.setHeight(1 + Math.max(getHeight(actual.getLeft()), getHeight(actual.getRight())));

        // Obtiene el balance
        int balance = getBalance(actual);

        // Rotaciones si está desequilibrado

        // Caso Izquierda-Izquierda
        if (balance > 1 && getBalance(actual.getLeft()) >= 0)
            return simpleRightRotation(actual);

        // Caso Izquierda-Derecha
        if (balance > 1 && getBalance(actual.getLeft()) < 0) {
            actual.setLeft(simpleLeftRotation(actual.getLeft()));
            return simpleRightRotation(actual);
        }

        // Caso Derecha-Derecha
        if (balance < -1 && getBalance(actual.getRight()) <= 0)
            return simpleLeftRotation(actual);

        // Caso Derecha-Izquierda
        if (balance < -1 && getBalance(actual.getRight()) > 0) {
            actual.setRight(simpleRightRotation(actual.getRight()));
            return simpleLeftRotation(actual);
        }

        return actual;
    }
    public Node<T> findMin(Node<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft(); // Recorre hacia la izquierda hasta encontrar el nodo mínimo
        }
        return node; // Devuelve el nodo mínimo encontrado
    }
    public Node<T> findMax(Node<T> node){
        while (node.getRight() != null) {
            node = node.getRight(); // Recorre hacia la derecha hasta encontrar el nodo máximo
        }
        return node; // Devuelve el nodo máximo encontrado
    }
    public boolean search(T data) {
        return searchRec(root, data); // Llama al método recursivo para buscar el dato
    }
    public boolean searchRec(Node<T> actual, T data) {
        if (actual == null) {
            return false; // Si el nodo actual es nulo, el dato no se encuentra
        }
        if (data.compareTo(actual.getData()) < 0) {
            return searchRec(actual.getLeft(), data); // Busca en el subárbol izquierdo
        } 
        else if (data.compareTo(actual.getData()) > 0) {
            return searchRec(actual.getRight(), data); // Busca en el subárbol derecho
        } 
        else {
            return true; // Si el dato es igual al del nodo actual, se ha encontrado
        }
    }
    public Node<T> findPredecessor(T data) {
        Node<T> actual = root;
        Node<T> predecessor = null;

        while (actual != null) {
            if (data.compareTo(actual.getData()) < 0) {
                actual = actual.getLeft(); // Si el dato es menor, va al subárbol izquierdo
            } 
            else if (data.compareTo(actual.getData()) > 0) {
                predecessor = actual; // Actualiza el predecesor
                actual = actual.getRight(); // Va al subárbol derecho
            } 
            else {
                if (actual.getLeft() != null) {
                    predecessor = findMax(actual.getLeft()); // Encuentra el máximo en el subárbol izquierdo
                }
                break; // Sale del bucle si encuentra el nodo
            }
        }
        return predecessor; // Devuelve el predecesor encontrado
    }
    public Node<T> findSuccessor(T data) {
        Node<T> actual = root;
        Node<T> successor = null;

        while (actual != null) {
            if (data.compareTo(actual.getData()) < 0) {
                successor = actual; // Actualiza el sucesor
                actual = actual.getLeft(); // Va al subárbol izquierdo
            } 
            else if (data.compareTo(actual.getData()) > 0) {
                actual = actual.getRight(); // Si el dato es mayor, va al subárbol derecho
            } 
            else {
                if (actual.getRight() != null) {
                    successor = findMin(actual.getRight()); // Encuentra el mínimo en el subárbol derecho
                }
                break; // Sale del bucle si encuentra el nodo
            }
        }
        return successor; // Devuelve el sucesor encontrado
    }
    public void inOrder() {
        inOrderRec(root); // Llama al método recursivo para imprimir en orden
    }
    public void inOrderRec(Node<T> node) {
        if (node != null) {
            inOrderRec(node.getLeft()); // Recorre el subárbol izquierdo
            System.out.print(node.getData() + " "); // Imprime el dato del nodo actual
            inOrderRec(node.getRight()); // Recorre el subárbol derecho
        }
    }
    public void preOrder() {
        preOrderRec(root); // Llama al método recursivo para imprimir en preorden
    }
    public void preOrderRec(Node<T> node) {
        if (node != null) {
            System.out.print(node.getData() + " "); // Imprime el dato del nodo actual
            preOrderRec(node.getLeft()); // Recorre el subárbol izquierdo
            preOrderRec(node.getRight()); // Recorre el subárbol derecho
        }
    }
    public void postOrder() {
        postOrderRec(root); // Llama al método recursivo para imprimir en postorden
    }
    public void postOrderRec(Node<T> node) {
        if (node != null) {
            postOrderRec(node.getLeft()); // Recorre el subárbol izquierdo
            postOrderRec(node.getRight()); // Recorre el subárbol derecho
            System.out.print(node.getData() + " "); // Imprime el dato del nodo actual
        }
    }
    public void printPretty() {
        printPrettyRec(root, "", true);
    }

    public void printPrettyRec(Node<T> node, String prefix, boolean isTail) {
        if (node == null) return;

        // Imprime el hijo derecho primero (para que aparezca arriba)
        if (node.getRight() != null) {
            printPrettyRec(node.getRight(), prefix + (isTail ? "│   " : "    "), false);
        }

        // Imprime el nodo actual
        System.out.println(prefix + (isTail ? "└── " : "┌── ") + node.getData());

        // Imprime el hijo izquierdo
        if (node.getLeft() != null) {
            printPrettyRec(node.getLeft(), prefix + (isTail ? "    " : "│   "), true);
        }
    }
    private int getHeight(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }
    private Node<T> simpleRightRotation(Node<T> y) {
        Node<T> x = y.getLeft();
        Node<T> T2 = x.getRight();

        // Realiza rotación
        x.setRight(y);
        y.setLeft(T2);

        // Actualiza alturas
        y.setHeight(Math.max(getHeight(y.getLeft()), getHeight(y.getRight())) + 1);
        x.setHeight(Math.max(getHeight(x.getLeft()), getHeight(x.getRight())) + 1);

        return x; // Nueva raíz
    }
    private Node<T> simpleLeftRotation(Node<T> x) {
        Node<T> y = x.getRight();
        Node<T> T2 = y.getLeft();

        // Realiza rotación
        y.setLeft(x);
        x.setRight(T2);

        // Actualiza alturas
        x.setHeight(Math.max(getHeight(x.getLeft()), getHeight(x.getRight())) + 1);
        y.setHeight(Math.max(getHeight(y.getLeft()), getHeight(y.getRight())) + 1);

        return y; // Nueva raíz
    }
    private int getBalance(Node<T> node) {
        if (node == null) {
            return 0; // Si el nodo es nulo, el balance es 0
        }
        return getHeight(node.getLeft()) - getHeight(node.getRight()); // Calcula el balance
    }
    public void exportToDot(String filename) { // Método para exportar el árbol AVL a un archivo DOT
        try (PrintWriter writer = new PrintWriter(filename)) { // Crea un PrintWriter para escribir en el archivo
            writer.println("digraph AVL {"); // Inicia el archivo DOT
            writer.println("    node [shape=circle];"); // Define la forma de los nodos como círculos
            writeDotRec(root, writer); // Llama al método recursivo para escribir el árbol en formato DOT
            writer.println("}"); // Cierra el archivo DOT
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    /* En caso que se quiera mostrar los nodos vacios
    private void writeDotRec(Node<T> node, PrintWriter writer) {
        if (node == null) return;

        if (node.getLeft() != null) {
            writer.printf("    \"%s\" -> \"%s\";%n", node.getData(), node.getLeft().getData());
            writeDotRec(node.getLeft(), writer);
        } else {
            writer.printf("    \"%s_lnull\" [shape=point];%n", node.getData());
            writer.printf("    \"%s\" -> \"%s_lnull\";%n", node.getData(), node.getData());
        }

        if (node.getRight() != null) {
            writer.printf("    \"%s\" -> \"%s\";%n", node.getData(), node.getRight().getData());
            writeDotRec(node.getRight(), writer);
        } else {
            writer.printf("    \"%s_rnull\" [shape=point];%n", node.getData());
            writer.printf("    \"%s\" -> \"%s_rnull\";%n", node.getData(), node.getData());
        }
    }
*/
// Si no se quiere mostrar los nodos vacíos, se puede usar el siguiente método:
    private void writeDotRec(Node<T> node, PrintWriter writer) { // Método recursivo para escribir el árbol en formato DOT
        if (node == null) return;

        if (node.getLeft() != null) { // Verifica si el hijo izquierdo no es nulo
            writer.printf("    \"%s\" -> \"%s\";%n", node.getData(), node.getLeft().getData()); // Conecta el nodo actual con su hijo izquierdo
            writeDotRec(node.getLeft(), writer); // Llama recursivamente para el subárbol izquierdo
        }

        if (node.getRight() != null) { // Verifica si el hijo derecho no es nulo
            writer.printf("    \"%s\" -> \"%s\";%n", node.getData(), node.getRight().getData()); // Conecta el nodo actual con su hijo derecho
            writeDotRec(node.getRight(), writer); // Llama recursivamente para el subárbol derecho
        }
    }




}