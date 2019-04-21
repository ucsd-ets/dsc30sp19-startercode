
import java.util.ArrayList;
import java.util.HashMap;

/**
 * TODO: add class header
 */
public class RuntimeAnalysis {

    HashMap<Long, Integer> a = new HashMap<>();


    private static final int NUM_DATA = 100000;
    private static final int NUM_SEARCH = 50000;
    private static final int NUM_RUN = 10;
    private static final int NUM_TEST = 5;
    private static final int MIN = 0;
    private static final int MAX = 100000;

    /**
     * Returns an ArrayList of random numbers
     *
     * @param size the number of random numbers wanted
     * @param min the min value for random number
     * @param max the max value for random number
     * @return an ArrayList of random numbers
     */
    public static ArrayList<Integer> randomNumbers(int size, int min, int max) {

        ArrayList<Integer> randNums = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            randNums.add((int) (Math.random() * ((max - min) + 1)) + min);
        }
        return randNums;
    }

    public static void timeInsertionSort(ArrayList<Integer> data, int numRun) {
        long startTime = 0, endTime = 0, totalTime = 0;
        Sorts<Integer> sorts = new Sorts<>();
        for (int i = 0; i < numRun; i++) {
            startTime = System.currentTimeMillis();
            sorts.InsertionSort(data, 0, data.size() - 1);
            endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        System.out.println();
        System.out.println("Benchmarking insertion sort: ");
        System.out.println("Number of data to sort: " + data.size());
        System.out.println("Average time taken to sort: " + totalTime / numRun + " ms");
        System.out.println();
    }

    public static void timeMergeSort(ArrayList<Integer> data, int numRun) {
        long startTime = 0, endTime = 0, totalTime = 0;
        Sorts<Integer> sorts = new Sorts<>();
        for (int i = 0; i < numRun; i++) {
            startTime = System.currentTimeMillis();
            sorts.MergeSort(data, 0, data.size() - 1);
            endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        System.out.println();
        System.out.println("Benchmarking merge sort: ");
        System.out.println("Number of data to sort: " + data.size());
        System.out.println("Average time taken to sort: " + totalTime / numRun + " ms");
        System.out.println();
    }

    public static void timeQuickSort(ArrayList<Integer> data, int numRun) {
        long startTime = 0, endTime = 0, totalTime = 0;
        Sorts<Integer> sorts = new Sorts<>();
        for (int i = 0; i < numRun; i++) {
            startTime = System.currentTimeMillis();
            sorts.QuickSort(data, 0, data.size() - 1);
            endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        System.out.println();
        System.out.println("Benchmarking quick sort: ");
        System.out.println("Number of data to sort: " + data.size());
        System.out.println("Average time taken to sort: " + totalTime / numRun + " ms");
        System.out.println();
    }

    public static void timeBinarySearch(ArrayList<Integer> sortedData, ArrayList<Integer> toSearch, int numRun) {
        long startTime = 0, endTime = 0, totalTime = 0;
        BinarySearch<Integer> binarySearch = new BinarySearch<>();
        for (int i = 0; i < numRun; i++) {
            startTime = System.currentTimeMillis();
            for (Integer num : toSearch) {
                binarySearch.binarySearch(sortedData, 0, sortedData.size() - 1, num);
            }
            endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        System.out.println();
        System.out.println("Benchmarking Binary Search on sorted array: ");
        System.out.println("Number of data in sorted array: " + sortedData.size());
        System.out.println("Number of data to search: " + toSearch.size());
        System.out.println("Average time taken to search: " + totalTime / numRun + " ms");
        System.out.println();
    }

    public static void timeLinearSearch(ArrayList<Integer> sortedData, ArrayList<Integer> toSearch, int numRun) {
        long startTime = 0, endTime = 0, totalTime = 0;
        for (int i = 0; i < numRun; i++) {
            startTime = System.currentTimeMillis();
            for (Integer num : toSearch) {
                for (Integer d : sortedData) {
                    if (d.equals(num)) {
                        break;
                    }
                }
            }
            endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        System.out.println();
        System.out.println("Benchmarking Linear Search on sorted array: ");
        System.out.println("Number of data in sorted array: " + sortedData.size());
        System.out.println("Number of data to search: " + toSearch.size());
        System.out.println("Average time taken to search: " + totalTime / numRun + " ms");
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> toSearch = randomNumbers(NUM_SEARCH, MIN, MAX);
        int numData = NUM_DATA;
        for (int i = 0; i < NUM_TEST; i++) {
            ArrayList<Integer> data = randomNumbers(numData, MIN, MAX);
            Sorts<Integer> sorts = new Sorts<>();
            sorts.QuickSort(data, 0, data.size() - 1);
            timeBinarySearch(data, toSearch, NUM_RUN);
            numData += numData;
        }

        numData = NUM_DATA;
        for (int i = 0; i < NUM_TEST; i++) {
            ArrayList<Integer> data = randomNumbers(numData, MIN, MAX);
            Sorts<Integer> sorts = new Sorts<>();
            sorts.QuickSort(data, 0, data.size() - 1);
            timeLinearSearch(data, toSearch, 1);
            numData += numData;
        }

        numData = NUM_DATA;
        for (int i = 0; i < NUM_TEST; i++) {
            ArrayList<Integer> data = randomNumbers(numData, MIN, MAX);
            timeQuickSort(data, NUM_RUN);
            numData += numData;
        }

        numData = NUM_DATA;
        for (int i = 0; i < NUM_TEST; i++) {
            ArrayList<Integer> data = randomNumbers(numData, MIN, MAX);
            timeMergeSort(data, NUM_RUN);
            numData += numData;
        }

        numData = NUM_DATA;
        for (int i = 0; i < NUM_TEST; i++) {
            ArrayList<Integer> data = randomNumbers(numData, MIN, MAX);
            timeInsertionSort(data, 1);
            numData += numData;
        }
    }


}
