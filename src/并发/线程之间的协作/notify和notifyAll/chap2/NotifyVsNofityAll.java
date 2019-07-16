package 并发.线程之间的协作.notify和notifyAll.chap2;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by ycz on 2019/7/16.
 */
public class NotifyVsNofityAll {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Task());
        }

        exec.execute(new Task2());

        Timer timer = new Timer();

        // 2秒钟后，执行一遍；再过2秒，再执行一遍，对象为同一个
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean prod = true;

            @Override
            public void run() {
                if (prod) {
                    System.out.println("\nnotify()");
                    // 在调用nofity、wait时，要先获得锁
                    Task.blocker.prod();
                    prod = false;
                } else {
                    System.out.println("\nnotifyAll()");
                    Task.blocker.prodAll();
                    prod = true;
                }
            }
        }, 2000, 2000);

        TimeUnit.SECONDS.sleep(5);
        timer.cancel();
        System.out.println("\nShutting down");
        exec.shutdownNow();
    }
}
