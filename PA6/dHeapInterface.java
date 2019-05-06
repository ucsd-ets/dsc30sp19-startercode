import java.util.NoSuchElementException;

public interface dHeapInterface<T extends Comparable<? super T>> {

    /**
     * Returns the number of elements stored in the heap.
     *
     * @return The number of elements stored in the heap.
     */
    int size();

    /**
     * Removes and returns the element at the root. If the heap is empty, then
     * this method throws a NoSuchElementException.
     *
     * @return The element at the root stored in the heap.
     * @throws NoSuchElementException if the heap is empty
     */
    T remove() throws NoSuchElementException;

    /**
     * Adds the specified element to the heap; o cannot be null. Resizes the
     * storage if full.
     *
     * @param o The element to add.
     * @throws NullPointerException if o is null.
     */
    void add(T o) throws NullPointerException;

    /**
     * Clears all the items in the heap Heap will be empty after this call
     * returns
     */
    public void clear();

    /**
     * Retrieves, but does not remove, the element at the root.
     *
     * @return item at the root of the heap
     * @throws NoSuchElementException - if this heap is empty
     */
    public T element() throws NoSuchElementException;
}
