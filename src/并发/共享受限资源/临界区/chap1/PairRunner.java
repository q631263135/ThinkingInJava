package 并发.共享受限资源.临界区.chap1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PairRunner implements Runnable {
    private static Pair pair = new Pair();

    @Override
    public void run() {
        pair.incrementX();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pair.incrementY();
        System.out.println(pair.getX() + " " + pair.getY());
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new PairRunner());

        TimeUnit.SECONDS.sleep(2);
        pair.checkState();

        System.out.println("main method over...");
    }
}
