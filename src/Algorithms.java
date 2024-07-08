import java.util.*;

public class Algorithms {

    public static List<Node> dijkstra(Graph graph, Node start, Node goal) {
        long startTime = System.nanoTime();

        Map<Node, Double> distances = new HashMap<>();
        Map<Node, Node> previousNodes = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));

        for (Node node : graph.getNodes()) {
            distances.put(node, Double.POSITIVE_INFINITY);
            previousNodes.put(node, null);
        }
        distances.put(start, 0.0);
        priorityQueue.add(start);

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();

            if (current.equals(goal)) {
                break;
            }

            for (Edge edge : current.getEdges()) {
                Node neighbor = edge.getTarget();
                double newDist = distances.get(current) + edge.getWeight();

                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    previousNodes.put(neighbor, current);
                    priorityQueue.add(neighbor);
                }
            }
        }

        List<Node> path = new ArrayList<>();
        for (Node at = goal; at != null; at = previousNodes.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);

        long endTime = System.nanoTime();
        System.out.println("Dijkstra's algorithm execution time: " + (endTime - startTime) + " nanoseconds");

        return path;
    }

    public static List<Node> aStar(Graph graph, Node start, Node goal) {
        long startTime = System.nanoTime();

        Map<Node, Double> gScores = new HashMap<>();
        Map<Node, Double> fScores = new HashMap<>();
        Map<Node, Node> previousNodes = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(fScores::get));

        for (Node node : graph.getNodes()) {
            gScores.put(node, Double.POSITIVE_INFINITY);
            fScores.put(node, Double.POSITIVE_INFINITY);
            previousNodes.put(node, null);
        }
        gScores.put(start, 0.0);
        fScores.put(start, heuristic(start, goal));
        priorityQueue.add(start);

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();

            if (current.equals(goal)) {
                break;
            }

            for (Edge edge : current.getEdges()) {
                Node neighbor = edge.getTarget();
                double tentativeGScore = gScores.get(current) + edge.getWeight();

                if (tentativeGScore < gScores.get(neighbor)) {
                    gScores.put(neighbor, tentativeGScore);
                    fScores.put(neighbor, tentativeGScore + heuristic(neighbor, goal));
                    previousNodes.put(neighbor, current);
                    priorityQueue.add(neighbor);
                }
            }
        }

        List<Node> path = new ArrayList<>();
        for (Node at = goal; at != null; at = previousNodes.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);

        long endTime = System.nanoTime();
        System.out.println("A* algorithm execution time: " + (endTime - startTime) + " nanoseconds");

        return path;
    }

    private static double heuristic(Node a, Node b) {
        // Example heuristic: Euclidean distance (assuming nodes have x, y coordinates)
        // Here, we just use 0 as a placeholder, assuming the graph is unweighted for simplicity
        return 0;
    }
}
