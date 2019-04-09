import java.util.NoSuchElementException;

public class CircularArrayQueue implements QueueADT {
    private static final int DEFAULT_SIZE = 5; // Example for declaring magic numbers
    private static final int GROWTH_FACTOR = 2; // Example for declaring magic numbers

    private int[] circularArray;
    private int length;
    private int head;
    private int tail;

    public CircularArrayQueue() {
        // TODO
    }

    public CircularArrayQueue(int capacity) {
        // TODO
    }

    public void add(int elem) {
        // TODO
    }

    private void resize() {
        // TODO
    }

    public boolean isEmpty() {
        // TODO

        return false;
    }


    public int peek() throws NoSuchElementException {
        // TODO

        return 0;
    }

    public int remove() throws NoSuchElementException {
        // TODO

        return 0;
    }

    public void clear() {
        // TODO
    }

    public int size() {
        // TODO

        return 0;
    }
}
