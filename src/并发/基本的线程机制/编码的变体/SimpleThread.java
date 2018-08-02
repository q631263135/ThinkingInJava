package 并发.基本的线程机制.编码的变体;

/**
 * Created by ycz on 2017/12/20.
 */
public class SimpleThread extends Thread {

    private static int id = 0;

    private int count = 6;

    public SimpleThread() {
        super(String.valueOf(++id));
    }

    @Override
    public void run() {
        while (count-- != 0) {
            System.out.println(getName() + "(" + count + ")");
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SimpleThread().start();
        }
    }
}
