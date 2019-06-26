package 并发.共享受限资源.临界区.chap3;

import java.util.concurrent.TimeUnit;

public class PairManagerSync2 extends PairManager {

    /**
     * synchronized block
     */
    @Override
    public void increment() {
        Pair temp;
        synchronized (this) {
            p.incrementX();
            p.incrementY();
            temp = getPair();
            System.out.println(Thread.currentThread() + " : " + p);
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 该方法不必进行防护，但不保证“原子性”
        store(temp);

    }
}
