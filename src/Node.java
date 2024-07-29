import java.util.ArrayList;
import java.util.List;

public class Node {
    private String name;
    private List<Edge> edges;
    private int x, y, floor;
    private boolean isPortal;

    public Node(String name, int x, int y, int floor, boolean isPortal) {
        this.name = name;
        this.edges = new ArrayList<>();
        this.x = x;
        this.y = y;
        this.floor = floor;
        this.isPortal = isPortal;
    }

    public String getName() {
        return name;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getFloor() {
        return floor;
    }

    public boolean isPortal() {
        return isPortal;
    }

    @Override
    public String toString() {
        return name + " (" + x + ", " + y + ", floor: " + floor + ")";
    }
}
