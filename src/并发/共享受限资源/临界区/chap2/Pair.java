package 并发.共享受限资源.临界区.chap2;

/**
 * Created by ycz on 2018/1/16.
 */

/**
 * 类非线程安全的，原因：x和y要保持一样的值，在对x访问的同时，并不能保证另外一个线程对y的修改
 * 在异常类中当检测到x不等于y时抛出异常
 */
public class Pair { // Not thread-safe

    private int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX() {
        x++;
    }

    public void incrementY() {
        y++;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public class PairValuesNotEqualException extends RuntimeException {

        public PairValuesNotEqualException() {
            super("Pair values not equal: " + Pair.this);
        }
    }

    public void checkState() {
        if (x != y) {
            throw new PairValuesNotEqualException();
        }
    }
}
