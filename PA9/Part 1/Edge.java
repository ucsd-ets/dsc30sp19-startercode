
public class Edge {

    private double distance; // the distance from source to target
    private final Vertex source; // the source vertex this edge starts from
    private final Vertex target; // the target vertex this edge ends at

    public Edge(Vertex vertex1, Vertex vertex2, double weight) {
        source = vertex1;
        target = vertex2;
        this.distance = weight;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Vertex getSource() {
        return source;
    }

    public Vertex getTarget() {
        return target;
    }

    public String toString() {
        return source + " - " + target;
    }
}