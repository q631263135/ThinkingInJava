package 并发.终结任务.装饰性花园.chap1;

import java.util.Random;

/**
 * 计数器
 */
class Count {
    private int count = 0;
    private Random rand = new Random(47);

    public synchronized int increment() {
        int temp = count;
        if (rand.nextBoolean()) {
            Thread.yield();
        }
        return (count = ++temp);
    }

    public synchronized int value() {
        return count;
    }
}
