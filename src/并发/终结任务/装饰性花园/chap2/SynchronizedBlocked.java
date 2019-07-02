package 并发.终结任务.装饰性花园.chap2;

/**
 * Created by ycz on 2019/7/2.
 */
public class SynchronizedBlocked implements Runnable {
    @Override
    public void run() {
        System.out.println("Trying to call f()");
        f();
        System.out.println("Exiting SynchronizedBlocked.run()");
    }

    private synchronized void f() {
        while (true) {
            Thread.yield(); // 臭不要脸
        }
    }

    public SynchronizedBlocked() {
        new Thread() {

            @Override
            public void run() {
                f();
            }
        }.start();
    }
}
