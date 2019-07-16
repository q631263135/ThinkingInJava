package 并发.线程之间的协作.notify和notifyAll.chap2;

public class Task implements Runnable {
    static Blocker blocker = new Blocker();
    @Override
    public void run() {
        blocker.waitingCall();
    }
}
