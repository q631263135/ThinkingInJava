package 并发.死锁.chap1;

/**
 * 筷子，自己维护有没有被拿走的状态
 * <br/>
 *
 * @author yangchaozheng
 * @date 2019/7/31 11:42
 */
public class Chopstick {
    private boolean taken = false;

    public synchronized void take() throws InterruptedException {
        while (taken) {
            wait();
        }
        taken = true;
    }

    public synchronized void drop() {
        taken = false;
        notifyAll();
    }
}
