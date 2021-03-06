package 并发.共享受限资源.原子类;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest2 implements Runnable {
    private int i = 0;

    private int getValue() {
        return i;
    }

    private void evenIncrement() {
        i++;
    }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Aborting");
                System.exit(0);
            }
        }, 5000);

        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicIntegerTest2 test = new AtomicIntegerTest2();
        exec.execute(test);

        while (true) {
            int val = test.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }

}
