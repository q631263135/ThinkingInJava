package 并发.新类库中的构件.Semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * <br/>
 *
 * @author yangchaozheng
 * @date 2019/10/18 18:55
 */
public class SemaphoreDemo {

    final static int SIZE = 25;

    public static void main(String[] args) throws InterruptedException {
        final Pool<Fat> pool = new Pool<>(Fat.class, SIZE);

        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < SIZE; i++) {
            exec.execute(new CheckoutTask<>(pool));
        }

        // 上面的线程已经把25个 胖子都取出来享用了
        // 下面的main线程，想来竞争胖子？你疯了吧！
        List<Fat> list = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {

            Fat f = pool.checkOut();
            System.out.println(i + ": main() thread checked out");
            f.operation();
            list.add(f);
        }

        Future<?> blocked = exec.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    pool.checkOut();
                } catch (InterruptedException e) {
                    System.out.println("checkOut() Interrupted, I can't wait anymore...");
                }
            }
        });

        TimeUnit.SECONDS.sleep(2);
        blocked.cancel(true);
        System.out.println("Checking in objects in " + list);
        for (Fat f : list) {
            pool.checkIn(f);
        }

        for (Fat f : list) { // Second checkIn ignored
            pool.checkIn(f);
        }
        exec.shutdown();
    }
}

class CheckoutTask<T> implements Runnable {

    private static int counter;
    private final int id = counter++;
    private Pool<T> pool;

    public CheckoutTask(Pool<T> pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        try {
            T item = pool.checkOut();
            System.out.println(this + "checked out " + item);
            TimeUnit.SECONDS.sleep(1);
            System.out.println(this + "checked in " + item);
            pool.checkIn(item);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "CheckoutTask " + id + " ";
    }
}

