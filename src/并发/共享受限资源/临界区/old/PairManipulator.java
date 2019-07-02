package 并发.共享受限资源.临界区.old;

import 并发.共享受限资源.临界区.old.临界资源类.PairManager;

/**
 * Created by ycz on 2018/1/17.
 */
class PairManipulator implements Runnable {
    private PairManager pm;

    public PairManipulator(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true)
            pm.increment();
    }

    @Override
    public String toString() {
        return "Pair: " + pm.getPair() + " checkCounter = " + pm.checkCounter.get();
    }
}
