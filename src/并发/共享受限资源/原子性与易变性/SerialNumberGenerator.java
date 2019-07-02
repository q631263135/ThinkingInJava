package 并发.共享受限资源.原子性与易变性;

public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;

    public static int nextSerialNumber() {
        return serialNumber++; // Not thread-safe
    }
}

// 第一件事，测试可见性，多个线程访问nextSerialNumber方法，累加到100
