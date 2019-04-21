import java.util.Comparator;

/**
 * This class defines a pair where the first element is a word and second element is the
 * number of occurrence of this word.
 */
public class Pair implements Comparable<Pair> {

    String word;
    int count;

    /**
     * The constructor that creates a pair of the given word with number of occurrence as 1.
     *
     * @param word the given word
     */
    public Pair(String word){
        this.word = word;
        this.count = 0;
    }

    /**
     * Getter for the word in this pair
     *
     * @return the word in this pair
     */
    public String getWord(){
        return word;
    }

    /**
     * Getter for the count in this pair
     * @return the number of occurrence of the word in this pair
     */
    public int getCount(){
        return count;
    }

    /**
     * Increase the number of occurrence of word in this pair by 1.
     */
    public void incCount(){
        this.count++;
    }

    /**
     * The comparison between different Pairs are defined by the
     * comparision between the words in Pairs
     * @param o the other Pair
     * @return 0 if words in two pairs are equal.
     *         Negative number if this word is smaller than word in other pair
     *         Positive number if this word is larger than word in other pair
     */
    @Override
    public int compareTo(Pair o) {
        return this.word.compareTo(o.getWord());
    }
}

/**
 * The customer comparator used to sort Pair by count
 */
class CountComp implements Comparator<Pair> {

    @Override
    public int compare(Pair o1, Pair o2) {
        return o2.getCount() - o1.getCount();
    }
}
