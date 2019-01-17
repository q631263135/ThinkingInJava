package IO.NIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by ycz on 2019/1/17.
 */
public class ChannelCopy {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
//        if (args.length != 2) {
//            System.out.println("arguments: sourcefile destfile");
//            System.exit(1);
//        }
        FileInputStream inputStream = new FileInputStream("E:\\Cache\\我的坚果云\\收件箱\\1.txt");
        FileOutputStream outputStream = new FileOutputStream("E:\\Cache\\我的坚果云\\收件箱\\2.txt");

        FileChannel in = inputStream.getChannel(),
                out = outputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        while (in.read(buffer) != -1) {
            buffer.flip(); // Prepare to writing
            out.write(buffer);
            buffer.clear(); // Prepare to reading
        }
    }
}
