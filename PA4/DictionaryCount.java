import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 * TODO: add class header
 */
public class DictionaryCount {

    /**
     * This method would read all the words from the given file and store them into
     * an ArrayList of Pairs, where each of the pair contains a word and count as 0.
     *
     * @param fileName the given file to be read
     * @return an ArrayList containing pairs storing all the words from the given file
     */
    private static ArrayList<Pair> readDict(String fileName){

        try {
            ArrayList<Pair> pairs = new ArrayList<>();
            Scanner sc = new Scanner(new File(fileName));

            // read numWords or readAll from the given file
            while(sc.hasNext()){
                pairs.add(new Pair(sc.next()));
            }
            sc.close();
            return pairs;
        }
        catch (IOException e) {
            System.out.println("File not found!");
            return null;
        }
    }

    /**
     * This method would read all the words from the given file and store them into
     * an ArrayList of Strings.
     *
     * @param fileName the given file to be read
     * @return an ArrayList containing all the words from the given file
     */
    private static ArrayList<String> readWords(String fileName){

        try {
            ArrayList<String> words = new ArrayList<>();
            Scanner sc = new Scanner(new File(fileName));

            // read numWords or readAll from the given file
            while(sc.hasNext()){
                words.add(sc.next());
            }
            sc.close();
            return words;
        }
        catch (IOException e) {
            System.out.println("File not found!");
            return null;
        }
    }

    public static ArrayList<Pair> populateDict(ArrayList<Pair> pairs) {
        // TODO
        return null;
    }

    public static boolean searchDict(ArrayList<Pair> dict, String toSearch) {
        
        // TODO
        return false;
    }

    public static void main(String[] args) {
        // TODO
    }
}
