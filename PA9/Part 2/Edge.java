
public class Edge {

    private double distance; // the distance from source to target
    private Vertex source; // the source vertex this edge starts from
    private Vertex target; // the target vertex this edge ends at

    public Edge(Vertex v1, Vertex v2, double weight) {
        source = v1;
        target = v2;
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