package 并发.共享受限资源.临界区.临界资源类;

/**
 * Created by ycz on 2018/1/17.
 */
public class PairManager1 extends PairManager {
    @Override
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(p);
    }
}
