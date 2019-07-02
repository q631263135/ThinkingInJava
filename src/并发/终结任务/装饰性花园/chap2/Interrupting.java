package 并发.终结任务.装饰性花园.chap2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by ycz on 2019/7/2.
 */
public class Interrupting {
    private static ExecutorService exec = Executors.newCachedThreadPool();

    static void test(Runnable runnable) throws InterruptedException {
        Future<?> future = exec.submit(runnable);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Interrupting " + runnable.getClass().getName());
        future.cancel(true);
        System.out.println("Interrupt sent to " + runnable.getClass().getName());
    }

    public static void main(String[] args) throws InterruptedException {
//        test(new SleepBlocked());
//        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());

        System.out.println("Aborting with System.exit(0)");
        System.exit(0);
    }
}
