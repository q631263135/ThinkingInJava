package 并发.新类库中的构件.CountDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by ycz on 2019/8/15.
 */
public class TaskPortion implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private static Random rand = new Random();
    private final CountDownLatch latch;

    public TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            doWork();
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
        System.out.println(this + "completed");
    }

    @Override
    public String toString() {
        return String.format("%1$-3d", id);
    }
}
