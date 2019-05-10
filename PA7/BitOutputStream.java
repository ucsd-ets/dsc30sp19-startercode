import java.io.DataOutputStream;
import java.io.IOException;

/**
 * A bit output stream that could write bit by bit
 *
 * DO NOT MODIFY THIS FILE!!!
 */
public class BitOutputStream {

    private static final int FULL = 8;
    private static final int BYTE_BITS = 8;

    private byte buf; // one byte buffer
    private int nbits; // number of bits written
    private DataOutputStream out; // the output stream

    /**
     *  Initialize a BitOutputStream that will use the given DataOutputStream as output
     * @param out
     */
    public BitOutputStream(DataOutputStream out) {
        this.buf = 0;
        this.nbits = 0;
        this.out = out;
    }

    /**
     * Write the buffer byte to the output, and clear the byte
     * @throws IOException
     */
    public void flush() throws IOException {
        this.out.writeByte(buf);
        this.buf = 0;
        this.nbits = 0;
    }

    /**
     * Write the least significant bit of the argument to the bit buffer
     * @param i the bit to be written to
     * @throws IOException
     */
    public void writeBit(int i) throws IOException{

        // if the buffer is full, flush the buffer first
        if (nbits == FULL) {
            flush();
        }

        // write the given bit to the buffer at proper location
        int loc = FULL - nbits - 1;
        buf = (byte) (buf | (i << loc));

        nbits++;
    }

    /**
     * Write a byte given by the argument to output stream
     * @param b the give byte
     */
    public void writeByte(byte b) throws IOException{
        for (int i = 0; i < BYTE_BITS; i++) {
            int loc = BYTE_BITS - i - 1;
            writeBit((int) (b >> loc) & 1);
        }
    }
}
