package 并发.性能调优.免锁容器.chap1;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <br/>
 *
 * @author yangchaozheng
 * @date 2019/8/28 14:58
 */
public class CopyOnWriteArrayListDemo {
    private List list = new CopyOnWriteArrayList();
    private Random rand = new Random(47);

    public CopyOnWriteArrayListDemo() {
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
    }

    public void test() {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Reader());
        exec.execute(new Writer());
    }

    public static void main(String[] args) {
        CopyOnWriteArrayListDemo demo = new CopyOnWriteArrayListDemo();
        demo.test();
    }

    class Writer implements Runnable {


        @Override
        public void run() {
            try {
                System.out.println("我正在修改数据");
                list.set(1, rand.nextInt());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Reader implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("睡之前我要看下数据");
                System.out.println(list.get(1));
                TimeUnit.SECONDS.sleep(2);
                System.out.println("醒来了我要看下数据");
                System.out.println(list.get(1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


