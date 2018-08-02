package 并发.共享受限资源.不正确的访问资源;

/**
 * 如果这个实例作为多个任务的共享资源，那么就要考虑，不同线程间对该实例的访问是否同步
 * Created by ycz on 2017/12/27.
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    @Override
    public int next() {
        ++currentEvenValue;
        Thread.currentThread().yield();
        ++currentEvenValue;
        if (currentEvenValue > 2000) {

            return 1;
        }
        System.out.println(currentEvenValue);
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
