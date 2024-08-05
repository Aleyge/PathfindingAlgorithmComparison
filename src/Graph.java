import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private final List<Edge> edges = new ArrayList<>(); // Tüm kenarların listesi
    private final Map<String, Node> nodes = new HashMap<>(); // Düğümler için bir harita

    // Yeni bir kenar ekler
    public void addEdge(int startX, int startY, int endX, int endY) {
        Edge edge = new Edge(startX, startY, endX, endY);
        edges.add(edge);
        edges.add(new Edge(endX, endY, startX, startY)); // İki yönlü ekle
    }

    // Tüm kenarları döndürür
    public List<Edge> getEdges() {
        return edges;
    }

    // Düğümleri ekler
    public void addNode(String name, int x, int y) {
        nodes.put(name, new Node(name, x, y));
    }

    // İsimle düğümü alır
    public Node getNode(String name) {
        return nodes.get(name);
    }

    // Verilen koordinatlarla bağlı kenarları döndürür
    public List<Edge> getConnectedEdges(int x, int y) {
        List<Edge> connected = new ArrayList<>();
        for (Edge edge : edges) {
            if ((edge.startX == x && edge.startY == y) || (edge.endX == x && edge.endY == y)) {
                connected.add(edge);
            }
        }
        return connected;
    }

    // Koordinatlarla düğüm alır
    public Node getNodeByCoordinates(int x, int y) {
        for (Node node : nodes.values()) {
            if (node.x == x && node.y == y) {
                return node;
            }
        }
        return null;
    }
}
