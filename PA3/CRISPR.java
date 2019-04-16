/*
 * NAME: TODO First Last
 * PID: TODO Axxxxxxxx
 */


/**
 * Gene Splicing CRISPR Simulator
 *
 * @author TODO
 * @since TODO
 */
public class CRISPR {

    /*Sequences to use/test your CRISPR functions on. Please add more as you test*/
    private static String simpleGenome = "ACATATA";

    private static String sequencedGenome = "AAATTCAAGCGAGGTGATTACAACAAATTTTGCTGATGGTTTAGGCGTA"
            + "CAATCCCCTAAAGAATATAATTAAGAAAATAGCATTCCTTGTCGCCTAGAATTACCTACCGGCGTCCACCATACCTTCG"
            + "ATATTCGCGCCCACTCTCCCATTAGTCGGCACAAGTGGATGTGTTGCGATTGCCCGCTAAGATATTCTAAGGCGTAACG"
            + "CAGATGAATATTCTACAGAGTTGCCGTACGCGTTGAACACTTCACGGATGATAGGAATTTGCGTATAGAGCGGGTCATT"
            + "GAAGGAGATTACACTCGTAGTTAACAACGGGCCCGGCTCTATCAGAACACGAGTGCCTTGAATAACATACTCATCACTA";

    private static String overlappingGuide = "UAU";
    private static String guideRNA = "CUAAUGU";
    private static String splicedGene = "TAGACAT";


    /**
     * Program Entry, this simply runs
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        /*Should print out ACATATA (unchanged)*/
        System.out.println(spliceDNA(simpleGenome, overlappingGuide, splicedGene));
    }

    /**
     *  Simulate gene splicing on a genome using CRISPR
     *
     * @param genomeSequence initial DNA encoding
     * @param guideSequence guideRNA encoding
     * @param splicedSequence target insertion gene encoding
     * @return modified genome
     */
    public static String spliceDNA(String genomeSequence, String guideSequence, String splicedSequence) {
        DoublyLinkedList<Character> genome = new DoublyLinkedList<>();
        DoublyLinkedList<Character> guideRNA = new DoublyLinkedList<>();

        populateFromDNA(genome, genomeSequence);
        populateDNAFromRNA(guideRNA, guideSequence);

        //TODO: Implement a splicing algorithm with will add the splicedSequence where appropriate to genome

        return transcribeGeneticCode(genome);
    }

    /**
     * This is a direct encoding of the genetic code from the String to a LinkedList
     * @param dnaList to populate
     * @param dnaString DNA string encoding
     */
    public static void populateFromDNA(DoublyLinkedList<Character> dnaList, String dnaString) {
        //TODO: Populate dnaList with the characters in s
    }

    /**
     * This is an encoding of of the DNA that binds with the RNA
     * Remember that DNA pairs up A-T C-G, and RNA pairs up A-U C-G
     * Thus the guide RNA AUCG would match with the DNA TAGC
     * @param dnaList to populate
     * @param rnaString RNA string encoding
     */
    public static void populateDNAFromRNA(DoublyLinkedList<Character> dnaList, String rnaString) {
        //TODO: Populate dnaList with the DNA representation of the RNA Sequence
    }

    /**
     * Recreate the original base sequence that was loaded into the list
     * @param geneticSequence list representation of the
     * @return base sequence of the genetic material
     */
    public static String transcribeGeneticCode(DoublyLinkedList<Character> geneticSequence) {
        String s = "";
        for (char c : geneticSequence) {
            s += c;
        }
        return s;
    }

}
