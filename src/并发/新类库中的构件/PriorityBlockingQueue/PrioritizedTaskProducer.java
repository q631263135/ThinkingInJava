package 并发.新类库中的构件.PriorityBlockingQueue;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by ycz on 2019/8/26.
 */
public class PrioritizedTaskProducer implements Runnable {
    private Random rand = new Random(47);
    private Queue<Runnable> queue;
    private ExecutorService exec;

    public PrioritizedTaskProducer(Queue<Runnable> queue, ExecutorService exec) {
        this.queue = queue;
        this.exec = exec;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            queue.add(new PrioritizedTask(rand.nextInt(10)));
            Thread.yield();
        }
//
//        for (int i = 0; i < 10; i++) {
//            try {
//                TimeUnit.MILLISECONDS.sleep(250);
//                queue.add(new PrioritizedTask(10));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

//        for (int i = 0; i < 10; i++) {
//            try {
//                TimeUnit.MILLISECONDS.sleep(250);
//                queue.add(new PrioritizedTask(i));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        queue.add(new PrioritizedTask.EndSentinel(exec));

        System.out.println("Finished PrioritizedTaskProducer");
    }
}
