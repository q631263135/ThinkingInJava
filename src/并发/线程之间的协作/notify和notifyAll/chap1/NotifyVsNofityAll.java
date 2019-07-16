package 并发.线程之间的协作.notify和notifyAll.chap1;

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
            /*
            synchronized void waitingCall() {
                try {
                    // 每个线程都不停的进入该方法，又不停的退出资源
                    while (!Thread.interrupted()) {
                        wait(); // 阻塞
                        System.out.println(Thread.currentThread() + " ");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
             */
        }

        exec.execute(new Task2());

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean prod = true;

            @Override
            public void run() {
                // java.lang.IllegalMonitorStateException 当前线程不含有当前对象的锁资源的时候，调用obj.notify()方法。
                if (prod) {
                    System.out.println("\nnotify()");
                    Task.blocker.notify(); // 到底哪一个线程会被通知到呢？
                    prod = false;
                } else {
                    System.out.println("\nnotifyAll()");
                    Task.blocker.notifyAll();
                    prod = true;
                }
            }
        }, 400, 400);

        TimeUnit.SECONDS.sleep(5);
        timer.cancel();
        System.out.println("\nShutting down");
        exec.shutdownNow();
    }
}
