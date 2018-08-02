package 并发.共享受限资源.临界区;

import sun.org.mozilla.javascript.internal.ast.TryStatement;
import 并发.共享受限资源.临界区.临界资源类.PairManager;
import 并发.共享受限资源.临界区.临界资源类.PairManager1;
import 并发.共享受限资源.临界区.临界资源类.PairManager2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by ycz on 2018/1/17.
 */
public class CriticalSection {
    static void testApproaches(PairManager p1, PairManager p2) {
        ExecutorService exec = Executors.newCachedThreadPool();

        PairManipulator
                pm1 = new PairManipulator(p1),
                pm2 = new PairManipulator(p2);

        exec.execute(pm1);
        exec.execute(pm2);


        PairChecker pairChecker1 = new PairChecker(p1);

        PairChecker pairChecker2 = new PairChecker(p2);

        exec.execute(pairChecker1);
        exec.execute(pairChecker2);

        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException ignore) {}

        System.out.println("pm1: " + pm1 + "\npm2: " + pm2);

        System.exit(0);
    }

    public static void main(String[] args) {
        PairManager
                p1 = new PairManager1(),
                p2 = new PairManager2();

        testApproaches(p1, p2);

    }
}
