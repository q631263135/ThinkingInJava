package 并发.终结任务.装饰性花园.chap1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 进入花园
 */
class Entrance implements Runnable {
    // 每次进入花园都会触发计数器计数，把计数器耦合进来
    private static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<>();
    private int number = 0;
    private final int id;
    private static volatile boolean canceled = false;

    public static void cancel() {
        canceled = true;
    }

    public Entrance(int id) {
        this.id = id;
        entrances.add(this);
    }

    @Override
    public void run() {
        while (!canceled) {
            synchronized (this) {
                number++;
            }

            System.out.println(this + " Total: " + count.increment());

            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
            }

            System.out.println("Stopping " + this);
        }
    }

    public synchronized int getValue() {
        return number;
    }

    @Override
    public String toString() {
        return "Entrance " + id + ": " + getValue();
    }

    public static int getTotalCount() {
        return count.value();
    }

    /**
     * 旨在对比Count的计数和当前对象的计数，也就是说，接下来的编程应该是面向一个Entrance，而不是多个
     * @return
     */
    public static int sumEntrances() {
        int sum = 0;
        for (Entrance entrance : entrances) {
            sum += entrance.getValue();
        }

        return sum;
    }
}
