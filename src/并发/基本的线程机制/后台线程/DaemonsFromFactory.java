package 并发.基本的线程机制.后台线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by ycz on 2017/12/19.
 */
public class DaemonsFromFactory implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " " + this);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool(new SimpleDaemonsFactory());
        for (int i = 0; i < 5; i++) {
            executorService.execute(new DaemonsFromFactory());
        }

        System.out.println("All daemons started...");
        Thread.currentThread().sleep(125);
    }
}
