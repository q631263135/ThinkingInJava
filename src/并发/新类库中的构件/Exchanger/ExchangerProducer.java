package 并发.新类库中的构件.Exchanger;

import java.util.List;
import java.util.concurrent.Exchanger;
import 泛型.泛型接口.Generator;

/**
 * <br/>
 *
 * @author yangchaozheng
 * @date 2019/10/18 19:31
 */
class ExchangerProducer<T> implements Runnable {


    private Generator<T> gen;

    private Exchanger<List<T>> exchanger;

    private List<T> holder;

    public ExchangerProducer(Generator<T> gen, Exchanger<List<T>> exchanger, List<T> holder) {
        this.gen = gen;
        this.exchanger = exchanger;
        this.holder = holder;
    }

    @Override
    public void run() {

        try {
            while (!Thread.interrupted()) {
                for (int i = 0; i < 10; i++) {
                    holder.add(gen.next());
                }

                holder = exchanger.exchange(holder);
            }
        } catch (InterruptedException e) {
        }

    }
}
