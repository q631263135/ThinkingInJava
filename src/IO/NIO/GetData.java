package IO.NIO;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * Created by ycz on 2019/1/21.
 */
public class GetData {
    private final int BSIZE = 1024;

    @Test
    public void printTheAllocationOfByteBuffer() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
        System.out.println(byteBuffer.limit());

        int i = 0;
        while (i++ < byteBuffer.limit())
            if (byteBuffer.get() != 0)
                System.out.println("nonzero");

        System.out.println(i);
    }

    @Test
    public void storeAndReadChar() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
        byteBuffer.wrap("hello".getBytes()); // 我认为这个byteBuffer底层的数组，就是hello.getBytes的值

        System.out.println(byteBuffer.remaining());

        byteBuffer.flip();
        System.out.println(byteBuffer.remaining());

        while (byteBuffer.remaining() > 0) {
//            byteBuffer.flip(); // 使用这条语句，会报错（java.nio.BufferUnderflowException）；不使用，打印都是 0
            System.out.println(byteBuffer.get()); // 这里难道不是打印hello的字节表示吗？
        }
    }

    @Test
    public void storeAndReadCharCorrect() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
        byteBuffer.wrap("hello".getBytes()); // 我认为这个byteBuffer底层的数组，就是hello.getBytes的值

        byteBuffer.put("hello".getBytes());
//        byteBuffer.rewind();

        while (byteBuffer.remaining() > 0) {
            System.out.print(byteBuffer.get() + " "); // 这里难道不是打印hello的字节表示吗？调用rewind才会打印
        }
    }

    @Test
    public void storeAndReadCharCorrect2() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
        byteBuffer.wrap("hello".getBytes()); // 我认为这个byteBuffer底层的数组，就是hello.getBytes的值

        CharBuffer charBuffer = byteBuffer.asCharBuffer();
        charBuffer.put("hello");

        while (byteBuffer.remaining() > 0) {
            System.out.print(byteBuffer.get() + " "); // 这里难道不是打印hello的字节表示吗？
        }
    }
}
