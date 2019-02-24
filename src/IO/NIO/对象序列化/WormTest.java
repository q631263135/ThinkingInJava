package IO.NIO.对象序列化;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * Created by ycz on 2019/2/24.
 */
public class WormTest {
    private Worm worm = null;

    @Before
    public void initWorm() {
        worm = new Worm(3, 'a');
    }

    @Test
    public void testPrintWorm() {
        System.out.println(worm);
    }

    // 持久化到磁盘
    @Test
    public void testSerializeWriteObjectDisk() throws IOException {
        FileOutputStream fos = new FileOutputStream(new File("worm.out"));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
        objectOutputStream.writeObject("Worm storage");
        objectOutputStream.writeObject(worm);
        objectOutputStream.close();
    }

    @Test
    public void testSerializeReadObjectDisk() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("worm.out");
        ObjectInputStream objectInputStream = new ObjectInputStream(fis);
        String s = (String)objectInputStream.readObject();
        Worm worm = (Worm)objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(s + ": " + worm);
    }

}