package 并发.基本的线程机制.优先级;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by ycz on 2017/12/16.
 */
public class SimplePriorities implements Runnable {
    private int countDown = 5;
    private volatile double d;
    private int priority;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Thread.currentThread() + ":" + countDown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true) {
            for (int i = 1; i < 1000; i++) {
                d += (Math.PI + Math.E) / (double)i;
                if (i % 100 == 0) {
                    Thread.yield();
                }
            }

            System.out.println(this);

            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new SimplePriorities(Thread.MAX_PRIORITY)); // 优先级从1~10，不能超出该范围
            executorService.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
    }
}

/**
 * 打印结果是优先级大的交替先打印，优先级低的在后面打印
 */
