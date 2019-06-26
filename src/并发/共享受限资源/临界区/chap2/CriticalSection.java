package 并发.共享受限资源.临界区.chap2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CriticalSection {
    public static void main(String[] args) {
        PairManager pm1 = new PairManagerSync();
        PairManager pm2 = new PairManagerSync2();

        PairManipulator pairManipulator1 = new PairManipulator(pm1);
        PairManipulator pairManipulator2 = new PairManipulator(pm2);

        PairChecker pairChecker1 = new PairChecker(pm1);
        PairChecker pairChecker2 = new PairChecker(pm2);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(pairManipulator1);
        executorService.execute(pairManipulator2);
        executorService.execute(pairChecker1);
        executorService.execute(pairChecker2);

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("pm1: " + pairManipulator1 + "\npm2: " + pairManipulator2);
        System.exit(0);
    }
}

class PairManipulator implements Runnable {
    private PairManager pm;

    public PairManipulator(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true) {
            pm.increment();
        }
    }

    public String toString() {
        return "Pair: " + pm.getPair() + " checkerCounter = " + pm.checkerCounter.get();
    }
}

class PairChecker implements Runnable {
    private PairManager pm;

    public PairChecker(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true) {
            pm.checkerCounter.incrementAndGet();
            pm.getPair().checkState();
        }
    }

}