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
public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();

    public void untimed() {
        boolean captured = lock.tryLock();

        try {
            System.out.println("tryLock(): " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public void timed() {
        boolean captured = false;

        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("tryLock(2, TimeUnit.SECONDS): " + captured);
        }

        finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();

        al.untimed();

        al.timed();

        new Thread() {
            { setDaemon(true); }
            public void run() {
                al.lock.lock();
                System.out.println("acquired");

                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                al.lock.unlock();
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    al.lock.unlock();
//                }

            }
        }.start();

//        Thread.yield(); // 这个可能演示不出效果，改用下面的sleep

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        al.untimed();
        al.timed();
    }
}
