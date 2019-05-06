import java.util.*;

public class dHeap<T extends Comparable<? super T>>
        implements dHeapInterface<T> {

    private T[] heap; //heap array
    private int d; //branching factor
    private int nelems;
    private boolean isMaxHeap; //boolean to indicate whether heap is max or min

    /**
     * Initializes a binary max heap with capacity = 5
     */
    public dHeap() {
        //TODO
    }

    /**
     * Initializes a binary max heap with a given initial capacity.
     *
     * @param heapSize The initial capacity of the heap.
     */
    public dHeap(int heapSize) {
        //TODO
    }

    /**
     * Initializes a d-ary heap (with a given value for d), with a given initial
     * capacity.
     *
     * @param d The number of child nodes each node in the heap should have.
     * @param heapSize The initial capacity of the heap.
     * @param isMaxHeap indicates whether the heap should be max or min
     * @throws IllegalArgumentException if d is less than one.
     */
    @SuppressWarnings("unchecked")
    public dHeap(int d, int heapSize, boolean isMaxHeap)
            throws IllegalArgumentException {
        //TODO
    }

    @Override
    public int size() {
        //TODO
        return -1;

    }

    @Override
    public void add(T data) throws NullPointerException {
        //TODO
    }

    @Override
    public T remove() throws NoSuchElementException {
        //TODO
        return null;
    }

    @Override
    public void clear() {
        //TODO
    }

    @Override
    public T element() {
        //TODO
        return null; 
    }
}
