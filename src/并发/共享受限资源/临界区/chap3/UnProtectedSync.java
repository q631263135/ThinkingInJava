package 并发.共享受限资源.临界区.chap3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class UnProtectedSync {

    public static void main(String[] args) {
        PairManager pm = new PairManagerSync2();
        PairManipulator pairManipulator = new PairManipulator(pm);

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(pairManipulator);
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pm.printStore();

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