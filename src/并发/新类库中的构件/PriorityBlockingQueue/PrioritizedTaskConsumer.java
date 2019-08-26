package 并发.新类库中的构件.PriorityBlockingQueue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by ycz on 2019/8/26.
 */
public class PrioritizedTaskConsumer implements Runnable {
    private PriorityBlockingQueue<Runnable> q;

    public PrioritizedTaskConsumer(PriorityBlockingQueue<Runnable> q) {
        this.q = q;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                q.take().run();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finished PrioritizedTaskConsumer");
    }
}
