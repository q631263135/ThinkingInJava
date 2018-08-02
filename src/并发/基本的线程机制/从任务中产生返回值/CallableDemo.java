package 并发.基本的线程机制.从任务中产生返回值;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by ycz on 2017/11/24 0024.
 */
class TaskWithResult implements Callable<String> {

    private final int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}

public class CallableDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();

        System.out.println(exec.submit(new TaskWithResult(100)));

        Future<String> future = exec.submit(new TaskWithResult(10000));
        System.out.println(future.isDone());
        System.out.println(future.isDone());

        System.out.println(future.isDone());
        System.out.println(future.isDone());

//        for (int i = 0; i < 10; i++) {
//            Thread.sleep(500);
//        }

        System.out.println(future.isDone());
        System.out.println(future.isDone());

        // 打印结果可能全是false、全是true，也可能是先false后true

//        List<Future<String>> results = new ArrayList<Future<String>>();
//        for (int i = 0; i < 10; i++) {
//            results.add(exec.submit(new TaskWithResult(i)));
//        }
//
//        for (Future<String> fs : results) {
//            try {
//                System.out.println(fs.get());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            } finally {
//                exec.shutdown();
//            }
//        }
    }
}

