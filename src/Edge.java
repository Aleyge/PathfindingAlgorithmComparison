public class Edge {
    private Node target;
    private double weight;

    public Edge(Node target, double weight) {
        this.target = target;
        this.weight = weight;
    }

    public Node getTarget() {
        return target;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Edge to " + target.getName() + " with weight " + weight;
    }
}
