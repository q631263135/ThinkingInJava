package 并发.基本的线程机制.休眠;

import 并发.基本的线程机制.定义任务.LiftOff;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by ycz on 2017/11/24 0024.
 */
public class SleepingTask extends LiftOff {
    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new SleepingTask());
//            Thread thread = new Thread(new SleepingTask());
//            thread.start();
        }
        exec.shutdown();
    }
}
/*
output:
#2(9)
#3(9)
#1(9)
#0(9)
#4(9)
#3(8)
#2(8)
#1(8)
#0(8)
#4(8)
#3(7)
#2(7)
#1(7)
#4(7)
#0(7)
#3(6)
#2(6)
#1(6)
#4(6)
#0(6)
#2(5)
#3(5)
#1(5)
#0(5)
#4(5)
#3(4)
#2(4)
#1(4)
#0(4)
#4(4)
#3(3)
#2(3)
#1(3)
#4(3)
#0(3)
#3(2)
#2(2)
#1(2)
#0(2)
#4(2)
#2(1)
#3(1)
#1(1)
#0(1)
#4(1)
#2(Liftoff!)
#3(Liftoff!)
#1(Liftoff!)
#0(Liftoff!)
#4(Liftoff!)*/
