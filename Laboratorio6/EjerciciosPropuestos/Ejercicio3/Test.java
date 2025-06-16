package Laboratorio6.EjerciciosPropuestos.Ejercicio3;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;


public class Test{
    public static void main(String[] args){
        System.setProperty("org.graphstream.ui", "swing");

        BST<Integer> bst = new BST<>();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        Graph graph = new SingleGraph("Árbol Binario");
        graph.setAttribute("ui.stylesheet", "node { shape: circle; size: 30px; fill-color: #66ccff; text-size: 20px; }");

        addNodesEdges(graph, bst.getRoot(), null);

        graph.display();
    }

    private static void addNodesEdges(Graph graph, Node<Integer> current, Node<Integer> parent) {
        if (current == null) return;

        String nodeId = String.valueOf(current.getData());

        if (graph.getNode(nodeId) == null) {
            org.graphstream.graph.Node graphNode = graph.addNode(nodeId);
            graphNode.setAttribute("ui.label", nodeId);
        }

        if (parent != null) {
            String parentId = String.valueOf(parent.getData());
            String edgeId = parentId + "-" + nodeId;
            if (graph.getEdge(edgeId) == null) {
                graph.addEdge(edgeId, parentId, nodeId, true);
            }
        }

        addNodesEdges(graph, current.getLeft(), current);
        addNodesEdges(graph, current.getRight(), current);
    }
}