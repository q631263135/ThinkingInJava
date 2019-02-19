package IO.NIO.内存映射文件;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by ycz on 2019/2/19.
 */
public class LargeMappedFiles {
    static int length = 0x400000; // 4MB

    public static void main(String[] args) throws IOException {
        FileChannel channel = new RandomAccessFile("text.dat", "rw").getChannel();
        MappedByteBuffer out = channel.map(FileChannel.MapMode.READ_WRITE, 0, length);
        for (int i = 0; i < length; i++) {
            out.put((byte)'x');
        }
        System.out.println("Finished writing");

        for (int i = length / 2; i < length / 2 + 6; i++) {
            System.out.println((char) out.get(i));
        }
    }

}
