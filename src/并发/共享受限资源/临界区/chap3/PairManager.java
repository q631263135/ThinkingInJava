package 并发.共享受限资源.临界区.chap3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

abstract class PairManager {
    AtomicInteger checkerCounter = new AtomicInteger(0);
    protected Pair p = new Pair(); // 把线程不安全的类代理过来
    private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());

    public synchronized Pair getPair() {
        return new Pair(p.getX(), p.getY());
    }

    protected void store(Pair p) {
        storage.add(p);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void printStore() {
        for (int i = 0; i < storage.size(); i++) {
            System.out.println(storage.get(i));
        }
    }

    public abstract void increment();

}
