package 并发.新类库中的构件.DelayQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * Created by ycz on 2019/8/22.
 */
public class DelayedTask implements Runnable, Delayed {
    private static int counter = 0;
    private final int id = counter++;
    private final int delta;
    private final long trigger;

    protected static List<DelayedTask> sequence = new ArrayList<>();


    public DelayedTask(int delayInMilliseconds) {
        this.delta = delayInMilliseconds;
        this.trigger = System.nanoTime() + NANOSECONDS.convert(delta, MILLISECONDS);
        sequence.add(this);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger - System.nanoTime(), NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed arg) {
        DelayedTask that = (DelayedTask)arg;
        if (trigger < that.trigger) {
            return -1;
        }
        if (trigger > that.trigger) {
            return 1;
        }
        return 0;
    }

    @Override
    public void run() {
        System.out.println(this + " ");
    }

    @Override
    public String toString() {
        return String.format("[%1$-4d]", delta + " Task " + id);
    }

    public String summary() {
        return "(" + id + ":" + delta + ")";
    }


    public static class EndSentinel extends DelayedTask {
        private ExecutorService exec;

        public EndSentinel(int delay, ExecutorService exec) {
            super(delay);
            this.exec = exec;
        }

        public void run() {
            for (DelayedTask pt : sequence) {
                System.out.println(pt.summary() + " ");
            }

            System.out.println();
            System.out.println(this + " Calling shutdownNow()");
            exec.shutdownNow();
        }
    }

}
