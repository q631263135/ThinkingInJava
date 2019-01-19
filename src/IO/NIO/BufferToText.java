package IO.NIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Created by ycz on 2019/1/18.
 */
public class BufferToText {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
//        BufferToText.wrapAndWrite();
//
//        BufferToText.readAndget();
//
//        BufferToText.asCharBufferWithoutDecode();
//        BufferToText.asCharBufferWithDecode();
        BufferToText.wrapWithEncodeAndWriteAndGet();
    }

    private static void wrapAndWrite() throws IOException {
        // 使用通道向data2.txt文件输出Some text
        FileChannel fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();
    }

    private static void readAndget() throws IOException {
        // 使用通道从data2.txt中读取并打印到控制台
        FileChannel fc = new FileInputStream("data2.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        fc.read(buffer);
        buffer.flip();

        // 调用get()方法，读取一个字节
        System.out.println((char)buffer.get());

        // 再读取一个字节
        System.out.println((char)buffer.get());
    }

    private static void asCharBufferWithoutDecode() throws IOException {
        FileChannel fc = new FileInputStream("data2.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        fc.read(buffer);
        buffer.flip();

        System.out.println(buffer.asCharBuffer());

    }

    private static void asCharBufferWithDecode() throws IOException {
        FileChannel fc = new FileInputStream("data2.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        fc.read(buffer);
        buffer.flip();

        String fileEncoding = System.getProperty("file.encoding");
        System.out.println(fileEncoding);

        CharBuffer decoded = Charset.forName(System.getProperty("file.encoding")).decode(buffer);

        System.out.println(decoded);
    }

    private static void wrapWithEncodeAndWriteAndGet() throws IOException {
        // 使用通道向data2.txt文件输出Some text
        FileChannel fc = new FileOutputStream("data3.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
        fc.close();


        fc = new FileInputStream("data3.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        fc.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());
    }
}
