package 并发.共享受限资源.临界区.old.临界资源类;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ycz on 2018/1/16.
 */
// Protect a Pair inside a thread-safe class
public abstract class PairManager {

    public AtomicInteger checkCounter = new AtomicInteger();

    protected Pair p = new Pair();

    private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());

    public synchronized Pair getPair() {

        return new Pair(p.getX(), p.getY());
    }

    protected void store(Pair p) {
        storage.add(p);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException ignore) {}

    }

    public abstract void increment();

}
