import java.util.ArrayList;

public class Vertex {

    private String name; // the name of this vertex
    private int x; // the x coordinates of this vertex on map
    private int y; // the y coordinates of this vertex on map

    // TODO: add additional instance variables to work with Disjoint Set and represent the graph

    public Vertex(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;

        // TODO: initialize your new instance variables
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // TODO: add getters and setters for your new instance variables

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Vertex)) {
            return false;
        }
        Vertex oVertex = (Vertex) o;

        return name.equals(oVertex.name) && x == oVertex.x && y == oVertex.y;
    }

    @Override
    public int hashCode() {
        // we assume that each vertex has a unique name
        return name.hashCode();
    }

    public String toString() {
        return name + " (" + x + ", " + y + ")";
    }

}