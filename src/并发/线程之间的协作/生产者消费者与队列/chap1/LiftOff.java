package 并发.线程之间的协作.生产者消费者与队列.chap1;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/11/10 0010.
 */
public class LiftOff implements Runnable{
    protected int countDown = 5;
    private static int taskCount = 0; // 静态变量，供每个实例共享
    private final int id = taskCount++; // final修改的变量，初始化后不能改变，没新生产一个实例，taskCouunt加一

    public LiftOff() {}

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + ")";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.yield();
        }
    }
}
