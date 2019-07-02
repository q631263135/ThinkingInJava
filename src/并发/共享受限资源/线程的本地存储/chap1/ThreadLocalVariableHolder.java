package 并发.共享受限资源.线程的本地存储.chap1;

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
//            exec.execute(() -> {
//                ThreadLocalVariableHolder.increment();
//
//                // 给其他线程执行的机会，然后返回到现场观察本来的变量值
//                Thread.yield();
//                System.out.println(Thread.currentThread() + " : " + ThreadLocalVariableHolder.get());
//            });
        }

        TimeUnit.SECONDS.sleep(1);
        exec.shutdownNow();
    }
}

/*
Thread[pool-1-thread-1,5,main] : 259
Thread[pool-1-thread-2,5,main] : 556
Thread[pool-1-thread-3,5,main] : 694
Thread[pool-1-thread-1,5,main] : 260
Thread[pool-1-thread-2,5,main] : 557

为什么线程1和线程2打印了两遍？不是应该执行一次吗？
因为newCachedThreadPool会回收已经执行完成的线程，如thread-1，执行完毕后，再次利用

Process finished with exit code 0*/
