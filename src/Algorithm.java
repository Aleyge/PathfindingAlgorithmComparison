import java.util.List;
import java.util.PriorityQueue;

public class Algorithm {
    // En kısa yolu bulur
    public void findShortestPath(Graph graph, String startName, String endName) {
        Node startNode = graph.getNode(startName); // Başlangıç düğümünü al
        Node endNode = graph.getNode(endName); // Bitiş düğümünü al

        if (startNode == null || endNode == null) {
            System.out.println("Geçersiz başlangıç veya bitiş noktası.");
            return;
        }

        // Başlangıç düğümünün mesafesini sıfırla ve kuyruğa ekle
        startNode.minDistance = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(startNode);

        while (!queue.isEmpty()) {
            Node current = queue.poll(); // Kuyruktan en yakın düğümü al

            if (current.equals(endNode)) {
                break; // Bitiş düğümüne ulaşıldı
            }

            // Mevcut düğümle bağlı kenarları al
            List<Edge> connectedEdges = graph.getConnectedEdges(current.x, current.y);
            for (Edge edge : connectedEdges) {
                // Kenarın bağlı olduğu komşu düğümü bul
                int[] otherCoords = edge.getOtherCoordinates(current.x, current.y);
                if (otherCoords != null) {
                    Node neighbor = graph.getNodeByCoordinates(otherCoords[0], otherCoords[1]);

                    if (neighbor != null) {
                        // Komşu düğüme olan yeni mesafeyi hesapla
                        double newDist = current.minDistance + edge.distance;

                        if (newDist < neighbor.minDistance) {
                            // Daha kısa bir yol bulundu, mesafeyi güncelle
                            neighbor.minDistance = newDist;
                            neighbor.previous = current;
                            if (!queue.contains(neighbor)) {
                                queue.add(neighbor); // Kuyruğa ekle
                            }
                        }
                    }
                }
            }
        }

        // En kısa yolun çıktısını alma
        if (endNode.minDistance == Double.POSITIVE_INFINITY) {
            System.out.println("Başlangıç ve bitiş noktaları arasında yol bulunamadı.");
        } else {
            System.out.println("En kısa mesafe: " + endNode.minDistance);
            printPath(endNode); // En kısa yolu yazdır
        }
    }

    // En kısa yolu yazdırır
    private void printPath(Node target) {
        if (target.previous != null) {
            printPath(target.previous);
            System.out.print(" -> ");
        }
        System.out.print(target);
    }
}
