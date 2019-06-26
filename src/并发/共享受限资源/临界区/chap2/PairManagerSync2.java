package 并发.共享受限资源.临界区.chap2;

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
        }
        // 该方法不必进行防护。
        store(temp);
    }
}
