package 并发.共享受限资源.临界区.old.临界资源类;

/**
 * Created by ycz on 2018/1/17.
 */
public class PairManager2 extends PairManager {
    @Override
    public void increment() {
        Pair temp;
        synchronized (this) {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        }
        store(temp);
    }
}
