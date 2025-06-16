package Laboratorio6.EjerciciosPropuestos.Ejercicio3;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;


public class TestBST3{
    public static void main(String[] args){
        BST<Integer> bst = new BST<>();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // Mostrar árbol en consola (ordenado)
        System.out.println("Árbol en orden:");
        bst.inOrder();

        // Visualización con GraphStream
        Graph graph = new SingleGraph("Árbol BST");
        graph.setAttribute("ui.stylesheet", "node { text-size: 20px; text-alignment: center; }");

        // Genera el grafo
        visualizeBST(graph, bst.getRoot(), null);

        graph.display();
    }

    // Método recursivo para construir el grafo desde el árbol
    private static void visualizeBST(Graph graph, Node<Integer> node, String parentId) {
        if (node == null) return;

        String nodeId = String.valueOf(node.getData());

        // Agrega el nodo si aún no existe
        if (graph.getNode(nodeId) == null) {
            graph.addNode(nodeId).setAttribute("ui.label", nodeId);
        }

        // Si tiene padre, crea la arista
        if (parentId != null) {
            String edgeId = parentId + "-" + nodeId;
            if (graph.getEdge(edgeId) == null) {
                graph.addEdge(edgeId, parentId, nodeId, true); // directed = true
            }
        }

        // Llamada recursiva
        visualizeBST(graph, node.getLeft(), nodeId);
        visualizeBST(graph, node.getRight(), nodeId);

    }
}