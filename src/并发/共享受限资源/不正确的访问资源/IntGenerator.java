package 并发.共享受限资源.不正确的访问资源;

/**
 * Created by ycz on 2017/12/27.
 */
public abstract class IntGenerator {
    private volatile boolean isCanceled = false;

    public abstract int next();

    public void cancel() {
        isCanceled = true;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

}
