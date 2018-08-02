package 并发.共享受限资源.临界区.会发生异常的代码;

import 并发.共享受限资源.临界区.临界资源类.PairManager;

/**
 * Created by ycz on 2018/1/16.
 */
public class PairManager1 extends PairManager {
    @Override
    public void increment() {
        p.incrementX();
        p.incrementY();
        store(p);
    }
}
