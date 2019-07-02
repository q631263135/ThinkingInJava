package 并发.共享受限资源.原子性与易变性;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VolatileTest {

    public static void main(String[] args) throws InterruptedException {

        final int[] result = {0};

        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 1; j <= 5; j++) {
                        result[0] = SerialNumberGenerator.nextSerialNumber();
                        System.out.println(Thread.currentThread() + " : " + result[0]);
                    }
                }
            });
        }

        TimeUnit.SECONDS.sleep(5);

        System.out.println(result[0]);
    }
}

// 即使不加volatile，多次执行也和有volatile没什么区别