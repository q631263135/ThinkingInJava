package 并发.终结任务.装饰性花园.chap2;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ycz on 2019/7/2.
 */
public class IOBlocked implements Runnable {

    private InputStream in;

    public IOBlocked(InputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        System.out.println("Waiting for read():");
        try {
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted from blocked I/O");
            } else {
                throw new RuntimeException();
            }
        }

        System.out.println("Exiting IOBlocked.run()");
    }
}
