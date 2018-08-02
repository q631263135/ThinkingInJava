package 并发.基本的线程机制.休眠;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by ycz on 2017/11/24 0024.
 */
public class PrintRandomNum implements Runnable {

    private static int taskCount = 0;

    private final int id = taskCount++;

    @Override
    public void run() {
        try {
            long sleepTime = Math.round(Math.random() * 10) * 1000;
            System.out.println("我是" + id + "号我要准备睡了zzZ，我打算睡" + sleepTime + "毫秒");
            TimeUnit.MILLISECONDS.sleep(sleepTime);
            System.out.println("我是" + id + "号我醒了，我睡了" + sleepTime + "毫秒");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new PrintRandomNum());
        }
    }
}
/*
我是0号我要准备睡了zzZ，我打算睡9000毫秒
我是1号我要准备睡了zzZ，我打算睡8000毫秒
我是2号我要准备睡了zzZ，我打算睡5000毫秒
我是4号我要准备睡了zzZ，我打算睡4000毫秒
我是3号我要准备睡了zzZ，我打算睡7000毫秒
我是4号我醒了，我睡了4000毫秒
我是2号我醒了，我睡了5000毫秒
我是3号我醒了，我睡了7000毫秒
我是1号我醒了，我睡了8000毫秒
我是0号我醒了，我睡了9000毫秒*/
