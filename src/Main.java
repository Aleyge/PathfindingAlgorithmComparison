import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Node'ları ekliyoruz (isim, x, y, floor, isPortal)
        graph.addNode("A", 0, 0, 0, false);
        graph.addNode("B", 10, 0, 0, false);
        graph.addNode("C", 5, 5, 0, false);
        graph.addNode("D", 10, 10, 0, false);
        graph.addNode("E", 15, 15, 0, false);
        graph.addNode("F", 20, 10, 1, true); // portal node
        graph.addNode("G", 25, 0, 1, false);

        // Ağırlıklı kenarları ekliyoruz
        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 1);
        graph.addEdge("B", "D", 3);
        graph.addEdge("B", "E", 8);
        graph.addEdge("C", "D", 2);
        graph.addEdge("C", "F", 6);
        graph.addEdge("D", "E", 4);
        graph.addEdge("F", "G", 8);

        // Node'ları ve kenarları yazdırmak için
        for (Node node : graph.getNodes()) {
            System.out.println("Node " + node.getName() + " has edges:");
            for (Edge edge : node.getEdges()) {
                System.out.println("  " + edge);
            }
        }

        List<Node> dijkstraPath = Algorithms.dijkstra(graph, graph.getNode("A"), graph.getNode("G"));
        System.out.println("Dijkstra's algorithm path: " + pathToString(dijkstraPath));
        System.out.println("Dijkstra's algorithm path length: " + calculatePathLength(dijkstraPath));

        List<Node> aStarPath = Algorithms.aStar(graph, graph.getNode("A"), graph.getNode("G"));
        System.out.println("A* algorithm path: " + pathToString(aStarPath));
        System.out.println("A* algorithm path length: " + calculatePathLength(aStarPath));
    }

    private static String pathToString(List<Node> path) {
        StringBuilder sb = new StringBuilder();
        for (Node node : path) {
            sb.append(node.getName()).append(" ");
        }
        return sb.toString().trim();
    }

    private static double calculatePathLength(List<Node> path) {
        double totalLength = 0.0;
        for (int i = 0; i < path.size() - 1; i++) {
            Node currentNode = path.get(i);
            Node nextNode = path.get(i + 1);
            for (Edge edge : currentNode.getEdges()) {
                if (edge.getTarget().equals(nextNode)) {
                    totalLength += edge.getWeight();
                    break;
                }
            }
        }
        return totalLength;
    }
}
