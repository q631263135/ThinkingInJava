package 并发.练习;

import java.util.concurrent.TimeUnit;

/**
 * Created by ycz on 2018/1/7.
 */
public class TT implements Runnable {
    private int i = 100;

    public synchronized void m1() throws InterruptedException {
        i = 1000;
        TimeUnit.SECONDS.sleep(2);
        System.out.println(i);
    }

    public void m2() {
//        i = 200;
        System.out.println(i);
    }

    @Override
    public void run() {
        try {
            m1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TT tt = new TT();
        Thread t = new Thread(tt);
        t.start();


//        TimeUnit.MILLISECONDS.sleep(1); // 加上这段和不加上这段运行结果是两样，不解
        tt.m2();
    }

}
