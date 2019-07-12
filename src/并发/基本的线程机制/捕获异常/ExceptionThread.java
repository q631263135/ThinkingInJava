package 并发.基本的线程机制.捕获异常;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ycz on 2019/4/27.
 */
public class ExceptionThread implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        try {
            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(new ExceptionThread());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
