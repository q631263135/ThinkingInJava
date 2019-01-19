package IO.NIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Created by ycz on 2019/1/18.
 */
public class BufferToText2 {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        FileChannel fc = new FileOutputStream("一些汉字.txt").getChannel();
//        fc.write(ByteBuffer.wrap("你好".getBytes("UTF-16BE")));
        fc.write(ByteBuffer.wrap("你好".getBytes("UTF-8")));
        fc.close();


        fc = new FileInputStream("一些汉字.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        fc.read(buffer);
        buffer.flip();

        System.out.println(buffer.get());
        System.out.println(buffer.get());


//        System.out.println(buffer.asCharBuffer());
        CharBuffer decoded = Charset.forName("UTF-8").decode(buffer);
        System.out.println(decoded);

        String[] split = "111001001011110110100000".split("");
        System.out.println(Arrays.deepToString(split));

        byte[] bytes = new byte[] {1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0};
        String s = new String(bytes, "UTF-8");
        System.out.println(s);

        byte[] bytes2 = new byte[] {1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0};
        String s2 = new String(bytes, "UTF-8");
        System.out.println(s2);

        System.out.println("好".getBytes("UTF-8"));

        byte[] 好 = "好".getBytes("UTF-8");
        StringBuffer hao = new StringBuffer();
        for (int i = 0; i < 好.length; i++) {
            hao.append(好[i]).append(",");
        }

        System.out.println("好".getBytes("UTF-16BE"));
        byte[] 好2 = "好".getBytes("UTF-16BE");
        StringBuffer hao2 = new StringBuffer();
        for (int i = 0; i < 好2.length; i++) {
            hao2.append(好2[i]).append(",");
        }

        System.out.println(hao);
        System.out.println(hao2);

    }
}
