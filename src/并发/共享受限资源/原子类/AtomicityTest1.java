package 并发.共享受限资源.原子类;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ycz on 2019/9/17.
 */
public class AtomicityTest1 implements Runnable {
    private int i = 0;

    public int getValue() {
        return i;
    }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    private synchronized void evenIncrement() {
        i++;
        i++;
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest1 at = new AtomicityTest1();
        exec.execute(at);
        while (true) {
            int val = at.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
