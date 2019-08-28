package 并发.性能调优.免锁容器.chap2;

import jdk.nashorn.internal.ir.WhileNode;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <br/>
 *
 * @author yangchaozheng
 * @date 2019/8/28 19:56
 */
public class FastSimulation {
    static final int N_ELEMENTS = 10000;
    static final int N_GENS = 30;
    static final int N_EVOLVERS = 50;
    static final AtomicInteger[][] GRID = new AtomicInteger[N_ELEMENTS][N_GENS];

    static Random rand = new Random(47);

    static class Evolver implements Runnable {

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                int element = rand.nextInt(N_ELEMENTS); // 997
                for (int i = 0; i < N_GENS; i++) {
                    int previous = element - 1;
                    if (previous < 0) {
                        previous = N_ELEMENTS - 1;
                    }
                    int next = element + 1;
//                    if (next > N_ELEMENTS - 1) {
                    if (next > N_ELEMENTS) {
                        next = 0;
                    }

                    int oldvalue = GRID[element][i].get();
                    System.out.printf("Previous: %1$d Next: %2$d%n", previous, next);
//                    System.out.println(Math.PI + Math.E / (double) 2.0);
                    int newvalue = oldvalue + GRID[previous][i].get() + GRID[next][i].get();
                    newvalue /= 3;
                    if (!GRID[element][i].compareAndSet(oldvalue, newvalue)) {
                        System.out.printf("Old value changed from %s%n", oldvalue);
                    }
                }
            }

        }


    }

    public static void main(String[] args) throws InterruptedException {
//        ExecutorService exec = Executors.newSingleThreadExecutor();
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < N_ELEMENTS; i++) {
            for (int j = 0; j < N_GENS; j++) {
                GRID[i][j] = new AtomicInteger(rand.nextInt(1000));
            }
        }

        for (int i = 0; i < N_EVOLVERS; i++) {
            exec.execute(new Evolver());
        }
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
