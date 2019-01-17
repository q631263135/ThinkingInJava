package IO.NIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by ycz on 2018/12/25.
 */
public class GetChannel {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        // 获取 data.txt 通道
        FileChannel fc = new FileOutputStream("data.txt").getChannel();

        // warp() 将已存在的字节数组“包装”到ByteBuffer中
        fc.write(ByteBuffer.wrap("Some".getBytes()));
        System.out.println(fc.size());
        fc.position(4);
        fc.write(ByteBuffer.wrap("Some text".getBytes()));

        fc.close();

        fc = new RandomAccessFile("data.txt", "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();

        fc = new FileInputStream("data.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
//        buff = ByteBuffer.allocateDirect(BSIZE); // 更快的速度

        // 调用read()来告知FileChannel向ByteBuffer存储字节
        fc.read(buff);
        buff.flip();
        while (buff.hasRemaining()) {
            byte b = buff.get();
            System.out.print((char) b);
//            System.out.println(Integer.toBinaryString(b) + " " + b + " " + (char)b);
        }

    }
}
