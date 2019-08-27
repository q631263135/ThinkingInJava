package 并发.新类库中的构件.Semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * <br/>
 *
 * @author yangchaozheng
 * @date 2019/8/27 16:59
 */
public class Pool<T> {
    private int size;
    private List<T> items = new ArrayList<>();
    private boolean[] checkedout;
    private Semaphore availiable;

    public Pool(Class<T> classObj, int size) {
        this.size = size;
        checkedout = new boolean[size];
        availiable = new Semaphore(size, true);

        for (int i = 0; i < size; i++) {
            try {
                items.add(classObj.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public T checkOut() throws InterruptedException {
        availiable.acquire();
        return getItem();
    }

    public void checkIn(T x) throws InterruptedException {
        if (releaseItem(x)) {
            availiable.release();
        }
    }

    private synchronized T getItem() {
        for (int i = 0; i < size; i++) {
            if (!checkedout[i]) {
                checkedout[i] = true;
                return items.get(i);
            }
        }
        return null;
    }

    private synchronized boolean releaseItem(T item) {
        int index = items.indexOf(item);
        if (index == -1) {
            return false;
        }
        if (checkedout[index]) {
            checkedout[index] = false;
            return true;
        }
        return false;
    }
}
