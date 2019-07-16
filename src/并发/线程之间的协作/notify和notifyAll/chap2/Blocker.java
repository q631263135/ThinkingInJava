package 并发.线程之间的协作.notify和notifyAll.chap2;

public class Blocker {
    synchronized void waitingCall() {
        try {
            while (!Thread.interrupted()) {
                wait();
                System.out.println(Thread.currentThread() + " ");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void prod() {
        notify();
    }

    synchronized void prodAll() {
        notifyAll();
    }

}
