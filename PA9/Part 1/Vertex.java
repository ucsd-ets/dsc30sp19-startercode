
public class Vertex {

    private final String name; // the name of this vertex
    private final int x; // the x coordinates of this vertex on map
    private final int y; // the y coordinates of this vertex on map

    // TODO: add additional instance variables to work with different graph traversal algorithm

    public Vertex(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
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

    // TODO: add necessary getters and setters for ALL your instance variable

    @Override
    public int hashCode() {
        // we assume that each vertex has a unique name
        return name.hashCode();
    }

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

    public String toString() {
        return name + " (" + x + ", " + y + ")";
    }

}