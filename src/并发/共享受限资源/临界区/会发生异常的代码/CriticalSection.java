package 并发.共享受限资源.临界区.会发生异常的代码;

import 并发.共享受限资源.临界区.临界资源类.PairManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by ycz on 2018/1/16.
 */
public class CriticalSection {
    static void testApproaches(PairManager p1) {
        ExecutorService exec = Executors.newCachedThreadPool();


        for (int i = 0; i < 10; i++) {
            PairChecker pcheck1 = new PairChecker(p1);
            exec.execute(pcheck1);
        }

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException ignore) {
        }

        System.out.println("p");
    }

    public static void main(String[] args) {
        PairManager p1 = new PairManager1();
        testApproaches(p1);
    }
}
