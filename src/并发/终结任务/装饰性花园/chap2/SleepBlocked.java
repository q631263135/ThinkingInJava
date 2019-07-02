package 并发.终结任务.装饰性花园.chap2;

import java.util.concurrent.TimeUnit;

/**
 * Created by ycz on 2019/7/2.
 */
public class SleepBlocked implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }

        System.out.println("Exiting SleepBlocked.run()");
    }
}
