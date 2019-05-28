import java.util.*;

/*
 * TODO: add class header
 */
public class Graph {

    // TODO: define a data structure to store all the vertices with fast access
    
    private ArrayList<Edge> allUndirectedEdges;
    private ArrayList<Edge> resultMST;
    private boolean edgesGiven;

    /**
     * Constructor for Graph
     */
    public Graph(boolean edgesGiven) {
        
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
     * Adds a directed edge from vertex u to vertex v, Throws IllegalArgumentException if one of
     * the vertex does not exist. If edgesGiven is false, directly return at first.
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
     * edge from u to v, then a directed edge from v to u. Then updates the allUndirectedEdges.
     * If edgesGiven is false, directly return at first.
     *
     * @param nameU name of vertex u
     * @param nameV name of vertex v
     * @param weight  weight of the edge between vertex u and v
     */
    public void addUndirectedEdge(String nameU, String nameV, double weight) {
        
        // TODO

    }

    /**
     * Calculates the euclidean distance for all edges in the graph and all edges in 
     * allUndirectedEdges. If edgesGiven is false, directly return at first.
     */
    public void computeAllEuclideanDistances() {
        
        // TODO

    }

    /**
     * Populate all possible edges from all vertices in the graph. Only works when edgesGiven 
     * is false. If edgesGiven is true, directly return at first.
     */
    public void populateAllEdges() {
        
        // TODO
        
    }

    /**
     * TODO: add Javadoc comments
     */
    public ArrayList<Edge> runKruskalsAlg() {
        // if resultMST is already computed, return the resultMST at first
        
        // TODO

        return null;
    }
}
