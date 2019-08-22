package 并发.新类库中的构件.DelayQueue;

import java.util.concurrent.DelayQueue;

/**
 * Created by ycz on 2019/8/22.
 */
public class DelayedTaskConsumer implements Runnable {
    private DelayQueue<DelayedTask> q;

    public DelayedTaskConsumer(DelayQueue<DelayedTask> q) {
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

        System.out.println("Finished DelayedTaskConsumer");
    }
}
