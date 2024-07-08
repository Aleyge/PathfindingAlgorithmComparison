import javax.crypto.AEADBadTagException;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Add nodes
        for(char i = 'A'; i <= 'G'; i++) {
            graph.addNode(String.valueOf(i));
        }

        // Add edges
        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 1);
        graph.addEdge("B", "D", 3);
        graph.addEdge("B", "E", 8);
        graph.addEdge("C", "D", 2);
        graph.addEdge("C", "F", 6);
        graph.addEdge("D", "E", 4);
        graph.addEdge("E", "G", 2);
        graph.addEdge("F", "G", 8);

        // Print the graph
        for (Node node : graph.getNodes()) {
            System.out.println("Node " + node.getName() + " has edges:");
            for (Edge edge : node.getEdges()) {
                System.out.println("  " + edge);
            }
        }
    }
}
