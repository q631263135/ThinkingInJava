package 并发.性能调优.免锁容器.chap2;

import 数组.从Generator中创建数组.Generated;
import 数组.创建测试数据.RandomGenerator;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <br/>
 *
 * @author yangchaozheng
 * @date 2019/8/28 16:32
 */
public abstract class Tester<C> {

    static int testReps = 10;
    static int testCycles = 10;
    static int containerSize = 10;

    abstract C containerInitializer();

    abstract void startReadersAndWriters();

    C testContainer;
    String testId;
    int nReaders;
    int nWriters;

    volatile long readResult = 0;
    volatile long readTime = 0;
    volatile long writeTime = 0;

    CountDownLatch endLatch;
    static ExecutorService exec = Executors.newCachedThreadPool();
    Integer[] writeData;

    public Tester(String testId, int nReaders, int nWriters) {
        this.testId = testId + " " + nReaders + "r" + " " + nWriters + "w";
        this.nReaders = nReaders;
        this.nWriters = nWriters;
        writeData = Generated.array(Integer.class, new RandomGenerator.Integer(), containerSize);
        for (int i = 0; i < testReps; i++) {
            runTest();
            readTime = 0;
            writeTime = 0;
        }
    }

    protected void runTest() {
        endLatch = new CountDownLatch(nReaders + nWriters);
        testContainer = containerInitializer();
        startReadersAndWriters();
        try {
            endLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%-27s %14d %14d%n", testId, readTime, writeTime);
        if (readTime != 0 && writeTime != 0) {
            System.out.printf("%-27s %14d%n", "readTime + writeTime =", readTime + writeTime);
        }
    }

    abstract class TestTask implements Runnable {
        abstract void test();

        abstract void putResults();

        long duration;

        @Override
        public void run() {
            long startTime = System.nanoTime();
            test();
            duration = System.nanoTime() - startTime;
            synchronized (Tester.this) {
                putResults();
            }

            endLatch.countDown();
        }

    }

    public static void initMain() {
        testReps = 5;
        testCycles = 5;
        containerSize = new Integer(10);
        System.out.printf("%-27s %14s %14s%n", "Type", "Read Time", "Write Time");

    }
}
