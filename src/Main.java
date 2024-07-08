import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // A'dan G ye kadar olan düğümleri ekliyorum
        for(char i = 'A'; i <= 'G'; i++) {
            graph.addNode(String.valueOf(i));
        }

        // ağırlıklı kenarları ekleyin
        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 1);
        graph.addEdge("B", "D", 3);
        graph.addEdge("B", "E", 8);
        graph.addEdge("C", "D", 2);
        graph.addEdge("C", "F", 6);
        graph.addEdge("D", "E", 4);
        graph.addEdge("E", "G", 2);
        graph.addEdge("F", "G", 8);

        // node'ları ve kenarları yazdırmak için
/** 
        for (Node node : graph.getNodes()) {
            System.out.println("Node " + node.getName() + " has edges:");
            for (Edge edge : node.getEdges()) {
                System.out.println("  " + edge);
            }
*/
       System.nanoTime();
       List<Node> dijkstraPath = Algorithms.dijkstra(graph, graph.getNode("A"), graph.getNode("G"));
       System.out.println("Dijkstra's algorithm path: " + pathToString(dijkstraPath));
       System.nanoTime();
       
       List<Node> aStarPath = Algorithms.aStar(graph, graph.getNode("A"),graph.getNode("G") );
       System.out.println("A* algorithm path: " + pathToString(aStarPath));
       System.nanoTime();
   }

   private static String pathToString(List<Node> path) {
       StringBuilder sb = new StringBuilder();
       for (Node node : path) {
           sb.append(node.getName()).append(" ");
       }
       return sb.toString().trim();
   }
}
