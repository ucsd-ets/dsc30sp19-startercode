import java.util.ArrayList;

/**
 * This class perform benchmarking on BST and BSA on find and insert operation
 */
public class Benchmark {

    private static final int NUM_INSERT = 50000;
    private static final int NUM_FIND = 50000;
    private static final int NUM_RUN = 5;
    private static final int NUM_TEST = 5;
    private static final int MIN = 0;
    private static final int MAX = Integer.MAX_VALUE - 1;

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

    /**
     * Prints the average time it takes for BST to find all elements in the given ArrayList.
     *
     * @param bst the given BST to search in
     * @param toFind the given ArrayList containing all elements to find
     * @param numRun number of run to take the average
     */
    public static void timeBSTFind(BSTree<Integer> bst, ArrayList<Integer> toFind, int numRun) {
        long startTime = 0, endTime = 0, totalTime = 0;
        for (int i = 0; i < numRun; i++) {
            for (Integer data : toFind) {
                startTime = System.currentTimeMillis();
                bst.findKey(data);
                endTime = System.currentTimeMillis();
                totalTime += (endTime - startTime);
            }
        }
        System.out.println();
        System.out.println("Benchmarking BST find: ");
        System.out.println("Number of data in given BST: " + bst.getSize());
        System.out.println("Number of data to find in BST: " + toFind.size());
        System.out.println("Average time taken: " + totalTime / numRun + " ms");
        System.out.println();
    }

    /**
     * Prints the average time it takes for BSA to find all elements in the given ArrayList.
     *
     * @param bsa the given BSA to search in
     * @param toFind the given ArrayList containing all elements to find
     * @param numRun number of run to take the average
     */
    public static void timeBSAFind(BinarySearchArray<Integer> bsa, ArrayList<Integer> toFind, int numRun) {
        long startTime = 0, endTime = 0, totalTime = 0;
        for (int i = 0; i < numRun; i++) {
            for (Integer data : toFind) {
                startTime = System.currentTimeMillis();
                bsa.find(data);
                endTime = System.currentTimeMillis();
                totalTime += (endTime - startTime);
            }
        }
        System.out.println();
        System.out.println("Benchmarking BSA find: ");
        System.out.println("Number of data in given BSA: " + bsa.getSize());
        System.out.println("Number of data to find in BSA: " + toFind.size());
        System.out.println("Average time taken: " + totalTime / numRun + " ms");
        System.out.println();
    }

    /**
     * Prints the average time it takes for BST to insert all elements in the given ArrayList.
     *
     * @param toInsert the given ArrayList containing all elements to insert
     * @param numRun number of run to take the average
     */
    public static void timeBSTInsert(ArrayList<Integer> toInsert, int numRun) {
        long startTime = 0, endTime = 0, totalTime = 0;
        for (int i = 0; i < numRun; i++) {
            BSTree<Integer> bst = new BSTree<>();
            for (Integer data : toInsert) {
                startTime = System.currentTimeMillis();
                bst.insert(data);
                endTime = System.currentTimeMillis();
                totalTime += (endTime - startTime);
            }
        }
        System.out.println();
        System.out.println("Benchmarking BST insertion: ");
        System.out.println("Number of data to insert: " + toInsert.size());
        System.out.println("Average time taken: " + totalTime / numRun + " ms");
        System.out.println();
    }

    /**
     * Prints the average time it takes for BSA to insert all elements in the given ArrayList.
     *
     * @param toInsert the given ArrayList containing all elements to insert
     * @param numRun number of run to take the average
     */
    public static void timeBSAInsert(ArrayList<Integer> toInsert, int numRun) {
        long startTime = 0, endTime = 0, totalTime = 0;
        for (int i = 0; i < numRun; i++) {
            BinarySearchArray<Integer> bsa = new BinarySearchArray<>();
            for (Integer data : toInsert) {
                startTime = System.currentTimeMillis();
                bsa.insert(data);
                endTime = System.currentTimeMillis();
                totalTime += (endTime - startTime);
            }
        }
        System.out.println();
        System.out.println("Benchmarking BSA insertion: ");
        System.out.println("Number of data to insert: " + toInsert.size());
        System.out.println("Average time taken: " + totalTime / numRun + " ms");
        System.out.println();
    }

    public static void main(String arg[]) {

        // Insert all Integers in toInsert to BST and BSA
        ArrayList<Integer> toInsert = randomNumbers(NUM_INSERT, MIN, MAX);
        BSTree<Integer> bst = new BSTree<>();
        BinarySearchArray<Integer> bsa = new BinarySearchArray<>();
        for (Integer i : toInsert) {
            bst.insert(i);
            bsa.insert(i);
        }

        // benchmark BST find
        int numFind = NUM_FIND;
        for (int i = 0; i < NUM_TEST; i++) {
            ArrayList<Integer> toFind = randomNumbers(numFind, MIN, MAX);
            timeBSTFind(bst, toFind, NUM_RUN);
            numFind += numFind;
        }

        // benchmark BSA find
        numFind = NUM_FIND;
        for (int i = 0; i < NUM_TEST; i++) {
            ArrayList<Integer> toFind = randomNumbers(numFind, MIN, MAX);
            timeBSAFind(bsa, toFind, NUM_RUN);
            numFind += numFind;
        }

        // benchmark BST insert
        int numInsert = NUM_INSERT;
        for (int i = 0; i < NUM_TEST; i++) {
            toInsert = randomNumbers(numInsert, MIN, MAX);
            timeBSTInsert(toInsert, NUM_RUN);
            numInsert += numInsert;
        }

        // benchmark BSA insert
        numInsert = NUM_INSERT;
        for (int i = 0; i < NUM_TEST; i++) {
            toInsert = randomNumbers(numInsert, MIN, MAX);
            timeBSAInsert(toInsert, NUM_RUN);
            numInsert += numInsert;
        }

    }

}
