package 并发.新类库中的构件.DelayQueue;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ycz on 2019/8/22.
 */
public class DelayQueueDemo {
    public static void main(String[] args) {
        Random rd = new Random(47);
        ExecutorService exec = Executors.newCachedThreadPool();

        DelayQueue<DelayedTask> queue = new DelayQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.put(new DelayedTask(rd.nextInt(5000)));
        }
        queue.add(new DelayedTask.EndSentinel(5000, exec));
        exec.execute(new DelayedTaskConsumer(queue));
    }
}
