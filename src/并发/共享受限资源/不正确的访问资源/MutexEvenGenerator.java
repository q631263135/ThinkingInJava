package 并发.共享受限资源.不正确的访问资源;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ycz on 2019/6/16.
 */
public class MutexEvenGenerator extends IntGenerator {
    private int currentEventValue = 0;

    private Lock lock = new ReentrantLock();

    @Override
    public int next() {
        lock.lock();
        try {
            ++currentEventValue;
            Thread.yield();
            ++currentEventValue;
            System.out.println(1 / 0);
            return currentEventValue;
        } finally {
//            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }
}
