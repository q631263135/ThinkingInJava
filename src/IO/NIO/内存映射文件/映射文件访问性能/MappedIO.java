package IO.NIO.内存映射文件.映射文件访问性能;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by ycz on 2019/2/23.
 */
public class MappedIO {
    private static int numOfInts = 4000000;
    private static int numOfUbuffInts = 200000;
    private abstract static class Tester {
        private String name;

        public Tester(String name) {
            this.name = name;
        }

        public void runTest() {
            System.out.println(name + ": ");

            long start = System.nanoTime();
            try {
                test();
            } catch (IOException e) {
                e.printStackTrace();
            }
            double duration = System.nanoTime() - start;
        }

        public abstract void test() throws IOException;


    }
    private static Tester[] tests = {
        new Tester("Stream Write") {
            @Override
            public void test() throws IOException {
                DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("temp.tmp"))));
                for (int i = 0; i < numOfInts; i++) {
                    dos.write(i);
                }
                dos.close();
            }
        },
        new Tester("Mapped Write") {
            @Override
            public void test() throws IOException {
                FileChannel fc = new RandomAccessFile("temp.tmp", "rw").getChannel();
                MappedByteBuffer map = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size());
                IntBuffer intBuffer = map.asIntBuffer();
                for (int i = 0; i < numOfInts; i++) {
                    intBuffer.put(i);
                }
                fc.close();

            }
        }
    };

    public static void main(String[] args) {
        for (Tester t : tests) {
            t.runTest();
        }
    }
}
