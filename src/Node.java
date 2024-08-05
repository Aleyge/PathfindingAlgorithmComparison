public class Node implements Comparable<Node> {
    public final int x; // Düğümün x koordinatı
    public final int y; // Düğümün y koordinatı
    public double minDistance = Double.POSITIVE_INFINITY; // Düğüme kadar olan en kısa mesafe
    public Node previous; // Önceki düğüm

    // Constructor: Düğümün adı, x ve y koordinatlarını alır
    public Node(String name, int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Düğümleri mesafeye göre karşılaştırır
    @Override
    public int compareTo(Node other) {
        return Double.compare(minDistance, other.minDistance);
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }
}
