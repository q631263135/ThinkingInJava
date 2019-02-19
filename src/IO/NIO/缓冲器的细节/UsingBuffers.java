package IO.NIO.缓冲器的细节;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * Created by ycz on 2019/1/30.
 */
public class UsingBuffers {
    private void symmerticScramble(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            buffer.mark();
            char c1 = buffer.get();
            char c2 = buffer.get();
            buffer.reset();
            buffer.put(c2).put(c1);
            System.out.println(buffer.position());
        }
    }

    @Test
    public void testSymmerticScramble() {
        char[] data = "UsingBuffers".toCharArray();
        ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
//        bb.wrap("UsingBuffers".getBytes());
        CharBuffer cb = bb.asCharBuffer();
        cb.put(data);
        System.out.println(cb.rewind());

        symmerticScramble(cb);

        System.out.println(cb.rewind());

        symmerticScramble(cb);

        System.out.println(cb.rewind());
    }

    @Test
    public void testSymmerticScramble2() {
        char[] data = "UsingBuffers".toCharArray();
        ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
        bb.wrap("UsingBuffers".getBytes());
        CharBuffer cb = bb.asCharBuffer();
        System.out.println(cb.rewind());
    }
}
