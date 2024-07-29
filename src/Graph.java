import java.util.*;

public class Graph {
    private Map<String, Node> nodes;

    public Graph() {
        nodes = new HashMap<>();
    }

    public Node addNode(String name, int x, int y, int floor, boolean isPortal) {
        Node node = new Node(name, x, y, floor, isPortal);
        nodes.put(name, node);
        return node;
    }

    public void addEdge(String from, String to, double weight) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        if (fromNode == null || toNode == null) {
            throw new IllegalArgumentException("Both nodes must exist in the graph.");
        }

        // İki yön için de kenar ekliyorum
        fromNode.addEdge(new Edge(toNode, weight));
        toNode.addEdge(new Edge(fromNode, weight));  
    }

    public Node getNode(String name) {
        return nodes.get(name);
    }

    public Collection<Node> getNodes() {
        return nodes.values();
    }
}
