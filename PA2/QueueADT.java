/**
 * This is an interface for the Queue ADT (Abstract Data Type). You can think
 * of this like a contract that specifies the public methods that all
 * concrete implementations need to provide
 */
public interface QueueADT {

    /**
     * Adds a new element to the tail of the Queue
     *
     * @param elem integer to add
     */
    void add(int elem);

    /**
     * Determines if the Queue is empty
     *
     * @return true if the number of elements in the Queue is 0
     */
    boolean isEmpty();

    /**
     * Returns the head of the Queue
     *
     * @return head of the Queue, or 0 if the Queue is empty
     */
    int peek();

    /**
     * Returns and removes the element at the head of the Queue
     *
     * @return head of the queue, or 0 if the Queue is empty
     */
    int remove();


    /**
     * Removes all elements from the Queue
     */
    void clear();

    /**
     * Determines the number of elements in the Queue
     *
     * @return number of elements in the Queue
     */
    int size();
}
