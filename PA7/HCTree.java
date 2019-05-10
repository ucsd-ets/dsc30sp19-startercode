
import java.io.*;
import java.util.PriorityQueue;

/**
 * The Huffman Coding Tree
 */
public class HCTree {

    private static final int NUM_CHARS = 256; // alphabet size of extended ASCII

    private HCNode root; // the root of HCTree
    private HCNode [] leaves = new HCNode[NUM_CHARS]; // the leaves of HCTree that contain all the symbols

    /**
     * The Huffman Coding Node
     */
    protected class HCNode implements Comparable<HCNode> {

        byte symbol; // the symbol contained in this HCNode
        int freq; // the frequency of this symbol
        HCNode c0, c1, parent; // c0 is the '0' child, c1 is the '1' child
        
        /**
         * Initialize a HCNode with given parameters
         * @param symbol the symbol contained in this HCNode
         * @param freq the frequency of this symbol
         */
        HCNode(byte symbol, int freq) {
            this.symbol = symbol;
            this.freq = freq;
        }

        /**
         * Getter for symbol
         * @return the symbol contained in this HCNode
         */
        byte getSymbol() {
            return this.symbol;
        }

        /**
         * Setter for symbol
         * @param symbol the given symbol
         */
        void setSymbol(byte symbol) {
            this.symbol = symbol;
        }

        /**
         * Getter for freq
         * @return the frequency of this symbol
         */
        int getFreq() {
            return this.freq;
        }

        /**
         * Setter for freq
         * @param freq the given frequency
         */
        void setFreq(int freq) {
            this.freq = freq;
        }

        /**
         * Getter for '0' child of this HCNode
         * @return '0' child of this HCNode
         */
        HCNode getC0() {
            return c0;
        }

        /**
         * Setter for '0' child of this HCNode
         * @param c0 the given '0' child HCNode
         */
        void setC0(HCNode c0) {
            this.c0 = c0;
        }

        /**
         * Getter for '1' child of this HCNode
         * @return '1' child of this HCNode
         */
        HCNode getC1() {
            return c1;
        }

        /**
         * Setter for '1' child of this HCNode
         * @param c1 the given '1' child HCNode
         */
        void setC1(HCNode c1) {
            this.c1 = c1;
        }

        /**
         * Getter for parent of this HCNode
         * @return parent of this HCNode
         */
        HCNode getParent() {
            return parent;
        }

        /**
         * Setter for parent of this HCNode
         * @param parent the given parent HCNode
         */
        void setParent(HCNode parent) {
            this.parent = parent;
        }

        /**
         * Check if the HCNode is leaf
         * @return if it's leaf, return 1. Otherwise, return 0.
         */
        boolean isLeaf() {
            return (c0 == null) && (c1 == null);
        }
        
        public String toString() {
            return "Symbol: " + this.symbol + "; Freq: " + this.freq;
        }

        public int compareTo(HCNode o) {
            // TODO
            return 0;
        }
    }

    public HCNode getRoot() {
        return root;
    }
    
    public void setRoot(HCNode root) {
        this.root = root;
    }
    
    public void buildTree(int[] freq) {

        // initialize a priority queue of HCNode
        PriorityQueue<HCNode> pq = new PriorityQueue<>();

        // TODO
    }

    public void encode(byte symbol, BitOutputStream out) throws IOException{

        // TODO
    }

    public byte decode(BitInputStream in) throws IOException{

        // TODO

        // found the leaf node and return the symbol
        return 0;
    }

    public void encodeHCTree(HCNode node, BitOutputStream out) throws IOException{

        // TODO: encode the structure of the HCTree and write it to the BitOutputStream

    }

    public HCNode decodeHCTree(BitInputStream in) throws IOException {

        // TODO: decode bits from the given BitInputStream and build the original HCTree

        return null;
    }

}
