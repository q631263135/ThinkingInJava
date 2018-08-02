package 并发.共享受限资源.不正确的访问资源;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ycz on 2017/12/27.
 */
public class EvenChecker implements Runnable {
    private final int id;

    private IntGenerator ge;
    public EvenChecker(int id, IntGenerator ge) {
        this.id = id;
        this.ge = ge;
    }


    @Override
    public void run() {
        while (!ge.isCanceled()) {
            int value = ge.next();
            if (value % 2 != 0) {
                System.out.println(this.id + ":" + value + " not even");
                ge.cancel();
            }
        }
    }

    public static void test(IntGenerator gp, int count) {
        for (int i = 0; i < count; i++) {
            ExecutorService es = Executors.newCachedThreadPool();
            es.execute(new EvenChecker(i, gp));
        }
    }

    public static void test(IntGenerator gp) {
        test(gp, 3);
    }
}
