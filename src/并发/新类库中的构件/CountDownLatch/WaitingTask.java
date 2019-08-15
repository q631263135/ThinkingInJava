package 并发.新类库中的构件.CountDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by ycz on 2019/8/15.
 */
public class WaitingTask implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private static Random rand = new Random();

    private final CountDownLatch latch;

    public WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
            System.out.println(this + "completed");
        } catch (InterruptedException e) {
            System.out.println(this + " interrupted");
        }
    }

    @Override
    public String toString() {
        return String.format("WaitingTask %1$-3d", id);
    }
}
