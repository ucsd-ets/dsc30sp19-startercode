
public class BloomFilter {
    public static final int NUMBITS = 8;

    byte[] table; // the byte array used as hash table of bits
    int numSlots; // the number of slots (bits) in the hash table

    /**
     * The constructor that creates a bloom filter of size numBytes in byte and 
     * with 8 * numBytes slots (in bits).
     *
     * @param numBytes the number of bytes allocated for the byte array
     */
    public BloomFilter(int numBytes) {

        //TODO
    }

    public void insert(String str) {

        //TODO
    }

    /**
     * Helper method to set a bit in the table to 1, which is specified by the given byteIndex 
     * and bitIndex
     * @param byteIndex the index of the byte in hash table
     * @param bitIndex the index of the bit in the byte at byteIndex. Range is [0, 7]
     */
    private void setBit(int byteIndex, int bitIndex) {
        // set the bit at bitIndex of the byte at byteIndex
        table[byteIndex] = (byte) (table[byteIndex] | ((1 << (NUMBITS - 1)) >> bitIndex));
    }

    public boolean find(String str) {
        
        //TODO
    }

    /**
     * Helper method to get the bit value at the slot, which is specified by the given byteIndex 
     * and bitIndex
     * @param byteIndex the index of the byte in hash table
     * @param bitIndex the index of the bit in the byte at byteIndex. Range is [0, 7]
     */
    private int getSlot(int byteIndex, int bitIndex) {
        return (table[byteIndex] >> ((NUMBITS - 1) - bitIndex)) & 1;
    }
}
