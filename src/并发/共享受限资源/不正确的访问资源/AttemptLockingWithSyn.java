package 并发.共享受限资源.不正确的访问资源;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ycz on 2019/6/18.
 *
 * tryLock只会执行一次
 *
 * tryLock也会lock
 *
 * 同一个线程中对相同方法片段可以多次加锁（多次调用）
 *
 */
public class AttemptLockingWithSyn {
    private ReentrantLock lock = new ReentrantLock();

    public synchronized void untimed() {
        System.out.println(Thread.currentThread() + "is running");
    }

    public synchronized void timed() {
        System.out.println(Thread.currentThread() + "is running");

    }

    public static void main(String[] args) {
        final AttemptLockingWithSyn al = new AttemptLockingWithSyn();

        al.untimed();

        al.timed();

        new Thread() {
            { setDaemon(true); }
            public void run() {
                al.untimed();
                al.timed();
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("acquired");
            }
        }.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        al.untimed();
        al.timed();
    }
}
