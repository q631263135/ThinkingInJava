package 并发.新类库中的构件.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ycz on 2019/8/15.
 */
public class CountDownLatchDemo {
    static final int SIZE = 10;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(SIZE); // 门闩

        for (int i = 0; i < 5; i++) {
            exec.execute(new WaitingTask(latch));
        }

        for (int i = 0; i < SIZE; i++) {
            exec.execute(new TaskPortion(latch));
        }

        System.out.println("Launched all tasks");
//        exec.shutdownNow();
    }
}
