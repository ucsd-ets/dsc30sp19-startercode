/**
 * This program takes in 3 command line arguments. The first one is the malicious URL file. The second one is the
 * mixed URL file, which contains malicious URLs from the given malicious URL file, and other safe URLs as well.
 * The third one is the name of the file to write your output to, which contains every URL from the mixed URL file
 * that are for sure known to be safe after using bloom filter (think about what that means about the
 * false positives), one URL per line.
 *
 * Note that you should only use at most 3 bytes for each 2 malicious URLs in your Bloom Filter. For example, if the 
 * malicious URL file contains 30000 URLs, then you should use at most 45000 bytes in your bloom filter.
 */
public class Firewall {
    /**
     * Main method that drives this program
     * @param args the command line argument
     */
    public static void main(String args[]) {

        //TODO

        // print statistics
        System.out.println("False positive rate: ");

        // Get the size of badURL in bytes
        File badURL = new File(args[0]);
        long inputSize = badURL.length();

        System.out.println("Saved memory ratio: ");
    }

}
