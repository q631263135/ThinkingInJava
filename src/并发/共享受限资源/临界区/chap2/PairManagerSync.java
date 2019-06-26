package 并发.共享受限资源.临界区.chap2;

public class PairManagerSync extends PairManager {

    /**
     * synchronized entire method
     */
    @Override
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}
