package 并发.基本的线程机制.编码的变体;

import java.util.concurrent.TimeUnit;

/**
 * 自管理的Runnable
 * Created by ycz on 2017/12/20.
 */
public class SelfManaged implements Runnable {

    private int countDown = 5;

    private static int i = 0;

    private Thread t = new Thread(this);

    @Override
    public void run() {
        while (true) {
            System.out.println(this + " i=" + i);

            if (--countDown == 0)
                return;
        }
    }

    public SelfManaged() throws InterruptedException {
//        t = new Thread(this);
        t.start();
        TimeUnit.MILLISECONDS.sleep(200);
        i++;
        ++countDown;
    }

    @Override
    public String toString() {
        return "#" + countDown + "-->t.getName(): " + t.getName() + ", Thread.currentThread().getName(): " + Thread.currentThread().getName();
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new SelfManaged();
        }
    }
}
