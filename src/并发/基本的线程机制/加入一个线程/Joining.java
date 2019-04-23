package 并发.基本的线程机制.加入一个线程;

/**
 * Created by ycz on 2019/4/23.
 */
public class Joining {

    public static void main(String[] args) {
        Sleeper sleepy = new Sleeper("Sleepy", 2500),
                grumpy = new Sleeper("Grumpy", 2500);

        Joiner dopey = new Joiner("Dopey", sleepy),
                doc = new Joiner("Doc", grumpy);

        grumpy.interrupt();
    }
}


class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int duration) {
        super(name);
        this.duration = duration;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted. isInterrupted: " + isInterrupted());
        }
        System.out.println(getName() + " has awakened.");
    }
}

class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            // sleeper 混入进来，当前线程挂起，直到 sleeper 睡醒
            sleeper.join();

            System.out.println();
            // 当前线程挂起，包括 join 后面的语句也不会执行
            System.out.println(getName() + " wating...");
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(getName() + " join completed.");
    }
}