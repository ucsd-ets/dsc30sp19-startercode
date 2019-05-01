import java.util.ArrayList;

public class BinarySearchArray<T extends Comparable<? super T>> {

    private ArrayList<T> sortedArray;

    public BinarySearchArray() {
        sortedArray = new ArrayList<>();
    }

    public BinarySearchArray(ArrayList<T> sortedArray) {
        this.sortedArray = sortedArray;
    }

    /**
     * This method will perform a binary search on the sortedArray.
     * If the element can be found in the array, this method should return the
     * index of that element. Otherwise, if the element is not in the array, this
     * method should still return the index where the given element should be inserted to.
     *
     * @param element the given element to find
     * @return the index of that element. Otherwise, if the element is not in the array, this
     *         method should still return the index where the given element should be inserted to.
     */
    private int binarySearch(T element) {
        int start = 0, end = sortedArray.size(), mid = 0;
        while (start < end) {
            mid = (end + start) / 2;
            int cmp = sortedArray.get(mid).compareTo(element);
            if (cmp == 0) {
                start = end = mid;
            }
            else if (cmp < 0) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return start;
    }

    public boolean insert(T element) {
        
        // TODO
        return true;
    }

    public T find(T element) {
        
        // TODO
        return null;
    }

    public int getSize() {
        return sortedArray.size();
    }

    public void printArray() {
        System.out.println(sortedArray.toString());
    }

}

