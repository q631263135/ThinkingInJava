package 并发.共享受限资源.原子性与易变性;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SerialNumberChecker {
    private static final int SIZE = 10;
    private static CircularSet circularSet = new CircularSet(1000);
    private static ExecutorService exec = Executors.newCachedThreadPool();

    static class SerialChecker implements Runnable {

        @Override
        public void run() {
            int serialNumber = SerialNumberGenerator.nextSerialNumber();
            if (circularSet.contains(serialNumber)) {
                System.out.println("Duplicate: " + serialNumber);
                System.exit(0);
            }
            circularSet.add(serialNumber);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < SIZE; i++) {
            exec.execute(new SerialChecker());
        }

        TimeUnit.SECONDS.sleep(10);
        // 自增操作在现代处理器上基本“原子性”
        System.out.println("No dumpliates detected");
        System.exit(0);
    }

}

class CircularSet {
    private int[] array;
    private int len;
    private int index = 0;

    public CircularSet(int size) {
        array = new int[size];
        len = size;
        for (int i = 0; i < size; i++) {
            array[i] = -1;
        }
    }

    public synchronized void add(int i) {
        array[index] = i;
        // Wrap index and write over old elements.
        // 这样不用开辟不明的空间，当空间不足rotate到前面来
        index = ++index % len;
    }

    public synchronized boolean contains(int val) {
        for (int i = 0; i < len; i++) {
            if (array[i] == val) {
                return true;
            }
        }
        return false;
    }
}