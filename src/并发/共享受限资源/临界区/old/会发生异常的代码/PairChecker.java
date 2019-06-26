package 并发.共享受限资源.临界区.old.会发生异常的代码;

import 并发.共享受限资源.临界区.old.临界资源类.PairManager;

/**
 * Created by ycz on 2018/1/16.
 */
public class PairChecker implements Runnable {
    private PairManager pm;

    public PairChecker(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true) {
            pm.checkCounter.incrementAndGet();
            pm.increment();
            pm.getPair().checkState();
            System.out.println(pm.checkCounter.get());
            if (pm.checkCounter.get() == 1000) {
                System.out.println("over...");
                System.exit(0);
            }
        }
    }
}
