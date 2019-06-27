package 并发.共享受限资源.线程的本地存储.chap2;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalVariableHolder {

    private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
        private Random rand = new Random(47);
        @Override
        protected Integer initialValue() {
            return rand.nextInt(1000);
        }
    };
    public static void increment() {
        value.set(value.get() + 1);
    }

    public static int get() {
        return value.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    while(!Thread.currentThread().isInterrupted()) {
                        ThreadLocalVariableHolder.increment();

                        // 给其他线程执行的机会，然后返回到现场观察本来的变量值
                        Thread.yield();
                        System.out.println(Thread.currentThread() + " : " + ThreadLocalVariableHolder.get());
                    }
                }
            });
        }

        TimeUnit.MILLISECONDS.sleep(100);
        exec.shutdownNow();
    }
}
