package 并发.基本的线程机制.后台线程;

import java.util.concurrent.TimeUnit;

/**
 * Created by ycz on 2017/12/19.
 */
public class SimpleDaemons implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SimpleDaemons());
        thread.setDaemon(true);
        thread.start();

        System.out.println("All daemons started...");

        TimeUnit.MILLISECONDS.sleep(3000);
    }
}
