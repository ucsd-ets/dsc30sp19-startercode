import java.io.DataInputStream;
import java.io.IOException;

/**
 * A bit input stream that could read bit by bit
 *
 * DO NOT MODIFY THIS FILE!!!
 */
public class BitInputStream {

    private static final int FULL = 8;
    private static final int BYTE_BITS = 8;

    private byte buf; // one byte buffer
    private int nbits; // number of bits read
    private DataInputStream in; // the input stream

    /**
     * Initialize a BitInputStream that will use the given DataInputStream as input
     * @param in the given DataInputStream
     */
    public BitInputStream(DataInputStream in) {
        this.buf = 0;
        // nbits is full, so that in readBit() would call fill() first to get the buffer
        this.nbits = FULL;
        this.in = in;
    }

    /**
     * Fill the buffer from the DataInputStream
     * @throws IOException
     */
    public void fill() throws IOException {
        this.buf = in.readByte();
        this.nbits = 0;
    }

    /**
     * Read the next bit from the bit buffer
     * @return 1 if next bit is 1; 0 if next bit is 0
     * @throws IOException
     */
    public int readBit() throws IOException {
        // if all bits in the buffer are read, fill the buffer first
        if (nbits == FULL) {
            fill();
        }

        // get the bit at the appropriate location in the bit buffer
        int nextBit;
        int loc = FULL - nbits - 1;
        nextBit = (buf >> loc) & 1;

        // increment the index to read next bit
        nbits++;

        return nextBit;

    }

    /**
     * Read a byte from the input
     * @return a byte from the input
     */
    public byte readByte() throws IOException {
        byte b = 0;
        for (int i = 0; i < BYTE_BITS; i++) {
            int loc = BYTE_BITS - i - 1;
            b = (byte) (b | (readBit() << loc));
        }
        return b;
    }


}
