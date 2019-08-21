package 并发.新类库中的构件.CyclicBarrier.chap1;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static 并发.新类库中的构件.CyclicBarrier.Horse.cyclicBarrier;

/**
 * Created by ycz on 2019/8/19.
 */
public class Horse implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private int strides = 0;
    private static Random rand = new Random(47);
    private volatile CountDownLatch countDownLatch4Race;
    private volatile CountDownLatch countDownLatch4Horse;

    public Horse(CountDownLatch countDownLatch4Race, CountDownLatch countDownLatch4Horse) {
        this.countDownLatch4Race = countDownLatch4Race;
        this.countDownLatch4Horse = countDownLatch4Horse;
    }

    public synchronized int getStrides() {
        return strides;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                synchronized (this) {
                    strides += rand.nextInt(3);
                    System.out.println(id + "在跑");
                }

                countDownLatch4Race.countDown();
                System.out.println(id + "在等countDownLatch4Race" + countDownLatch4Race.getCount());
                countDownLatch4Horse.await();
                System.out.println(id + "countDownLatch4Horse释放");
                countDownLatch4Horse = new CountDownLatch(1); // 这里存在多个线程同步问题
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Horse " + id + " ";
    }

    /**
     * 马儿跑了多少路，只有外部能给出量化的数字，马儿只知道跑
     *
     * @return
     */
    public String tracks() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getStrides(); i++) {
            sb.append("*");
        }

        sb.append(id);
        return sb.toString();
    }
}
