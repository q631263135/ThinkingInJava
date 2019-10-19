package 并发.新类库中的构件.Exchanger;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * <br/>
 *
 * @author yangchaozheng
 * @date 2019/10/18 19:36
 */
class ExchangerConsumer<T> implements Runnable {

    private Exchanger<List<T>> exchanger;

    private List<T> holder;

    private volatile T value;

    public ExchangerConsumer(Exchanger<List<T>> exchanger, List<T> holder) {
        this.exchanger = exchanger;
        this.holder = holder;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                holder = exchanger.exchange(holder);
                for (T x : holder) {
                    value = x;
                    holder.remove(x);
                }

                holder = exchanger.exchange(holder);
            }

        } catch (InterruptedException e) {
        }
        System.out.printf("Final value: %s", value);
    }
}
