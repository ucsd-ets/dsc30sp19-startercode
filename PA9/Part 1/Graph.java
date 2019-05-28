import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;

public class Graph {

    // TODO: define a data structure to store all the vertices with fast access

    /**
     * Constructor for Graph
     */
    public Graph() {

        // TODO

    }

    /**
     * Adds a vertex to the graph. Throws IllegalArgumentException if given vertex
     * already exist in the graph.
     *
     * @param v vertex to be added to the graph
     * @throws IllegalArgumentException if two vertices with the same name are added.
     */
    public void addVertex(Vertex v) throws IllegalArgumentException {

        // TODO

    }

    /**
     * Gets a collection of all the vertices in the graph
     *
     * @return collection of all the vertices in the graph
     */
    public Collection<Vertex> getVertices() {

        // TODO

        return null;
    }

    /**
     * Gets the vertex object with the given name
     *
     * @param name name of the vertex object requested
     * @return vertex object associated with the name
     */
    public Vertex getVertex(String name) {

        // TODO

        return null;
    }

    /**
     * Adds a directed edge from vertex u to vertex v, Throws IllegalArgumentException if one of
     * the vertex does not exist
     *
     * @param nameU name of vertex u
     * @param nameV name of vertex v
     * @param weight weight of the edge between vertex u and v
     * @throws IllegalArgumentException if one of the vertex does not exist
     */
    public void addEdge(String nameU, String nameV, Double weight) throws IllegalArgumentException {

        // TODO

    }

    /**
     * Adds an undirected edge between vertex u and vertex v by adding a directed
     * edge from u to v, then a directed edge from v to u
     *
     * @param nameU name of vertex u
     * @param nameV name of vertex v
     * @param weight  weight of the edge between vertex u and v
     */
    public void addUndirectedEdge(String nameU, String nameV, double weight) {

        // TODO

    }

    /**
     * Computes the euclidean distance between two points as described by their
     * coordinates
     *
     * @param ux (double) x coordinate of point u
     * @param uy (double) y coordinate of point u
     * @param vx (double) x coordinate of point v
     * @param vy (double) y coordinate of point v
     * @return (double) distance between the two points
     */
    public double computeEuclideanDistance(double ux, double uy, double vx, double vy) {

        // TODO

        return 0.0;
    }

    /**
     * Calculates the euclidean distance for all edges in the map using the
     * computeEuclideanCost method.
     */
    public void computeAllEuclideanDistances() {

        // TODO

    }

    /**
     * Helper method to reset all the vertices before doing graph traversal algorithms
     */
    private void resetAllVertices() {

        // TODO

    }

    /**
     * Find the path from vertex with name s to vertex with name t, using DFS
     *
     * @param s the name of the starting vertex
     * @param t the name of the targeting vertex
     */
    public void DFS(String s, String t) {

        // TODO

    }

    /**
     * Find the path from vertex with name s to vertex with name t, using BFS
     *
     * @param s the name of the starting vertex
     * @param t the name of the targeting vertex
     */
    public void BFS(String s, String t) {

        // TODO

    }

    /**
     * Helper class for Dijkstra and A*, used in priority queue
     */
    private class CostVertex implements Comparable<CostVertex> {
        double cost;
        Vertex vertex;

        public CostVertex(double cost, Vertex vertex) {
            this.cost = cost;
            this.vertex = vertex;
        }

        public int compareTo(CostVertex o) {
            return Double.compare(cost, o.cost);
        }
    }

    /**
     * Find the shortest path from vertex with name s to vertex with name t, using Dijkstra
     *
     * @param s the name of starting vertex
     * @param t the name of targeting vertex
     */
    public void Dijkstra(String s, String t) {
        PriorityQueue<CostVertex> queue = new PriorityQueue<>();

        // TODO

    }

    /**
     * Helper method to calculate the h value in A*
     *
     * @param cur the current vertex being explored
     * @param goal the goal vertex to reach
     * @return the h value of cur and goal vertices
     */
    private double hValue(String cur, String goal) {

        // TODO

        return 0.0;
    }

    /**
     * Find the path from vertex with name s to vertex with name t, using A*
     *
     * @param s the name of starting vertex
     * @param t the name of targeting vertex
     */
    public void AStar(String s, String t) {

        // TODO

    }

    /**
     * Returns a list of edges for a path from city s to city t.
     *
     * @param s starting city name
     * @param t ending city name
     * @return list of edges from s to t
     */
    public List<Edge> getPath(String s, String t) {

        // TODO

        return null;
    }

}
