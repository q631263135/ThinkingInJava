package IO.NIO.对象序列化;

import org.junit.Test;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by ycz on 2019/2/24.
 */
public class Worm implements Serializable {
    private static Random rd = new Random(47);

    private Data[] d = {
            new Data(rd.nextInt(10)),
            new Data(rd.nextInt(10)),
            new Data(rd.nextInt(10))
    };

    private Worm next;
    private char c;

    public Worm(int i, char c) {
        System.out.println("Worm constructor: " + i);
        this.c = c;
        if (--i > 0) {
            next = new Worm(i, (char) (c + 1));
        }
    }

    public Worm() {
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(":");
        result.append(c);
        result.append("(");
        for (Data dat : d) {
            result.append(dat);
        }
        result.append(")");
        if (next != null) {
            result.append(next);
        }
        return result.toString();
    }

}

class Data implements Serializable {
    private int n;

    public Data(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }
}