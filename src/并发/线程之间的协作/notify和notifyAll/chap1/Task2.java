package 并发.线程之间的协作.notify和notifyAll.chap1;

public class Task2 implements Runnable {
    static Blocker blocker = new Blocker();

    @Override
    public void run() {
        blocker.waitingCall();
    }
}
