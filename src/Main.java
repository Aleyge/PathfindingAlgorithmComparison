public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        Algorithm algorithm = new Algorithm();

        // Örnek kenarları ekleyin
        graph.addEdge(25, 30, 12, 29); // Kenar 1
        graph.addEdge(12, 29, 13, 35); // Kenar 2
        graph.addEdge(13, 35, 15, 25); // Kenar 3 (Alternatif yol)
        graph.addEdge(25, 30, 15, 25); // Kenar 4 (Alternatif yol)
        graph.addEdge(15, 25, 10, 20); // Kenar 5 (Alternatif yol)

        // Düğümleri ekleyin
        graph.addNode("Gucci", 15, 25);
        graph.addNode("LC Waikiki", 13, 35);
        graph.addNode("Center", 12, 29);
        graph.addNode("Start", 25, 30);
        graph.addNode("End", 10, 20);
        graph.addNode("Zara", 17, 25);
        // Testler: Farklı yolların en kısa mesafelerini bulma
        System.out.println("Test 1: Start'tan LC Waikiki'ye");
        algorithm.findShortestPath(graph, "Start", "LC Waikiki");

        System.out.println("\nTest 2: Start'tan Gucci'ye");
        algorithm.findShortestPath(graph, "Start", "Gucci");

        System.out.println("\nTest 3: Gucci'den End'e");
        algorithm.findShortestPath(graph, "Gucci", "End");

        System.out.println("\nTest 4: LC Waikiki'den End'e");
        algorithm.findShortestPath(graph, "LC Waikiki", "End");
        
        System.out.println("\nTest 4: LC Waikiki'den Zara'ya");
        algorithm.findShortestPath(graph, "LC Waikiki", "Zara");
    }
}


