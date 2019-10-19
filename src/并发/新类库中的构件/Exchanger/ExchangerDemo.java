package 并发.新类库中的构件.Exchanger;


import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import 并发.新类库中的构件.Semaphore.Fat;
import 泛型.泛型接口.Generator;

/**
 * <br/>
 *
 * @author yangchaozheng
 * @date 2019/10/18 19:39
 */
public class ExchangerDemo {

    static int size = 10;
    static int delay = 5;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<List<Fat>> xc = new Exchanger<>();

        List<Fat> producerList = new CopyOnWriteArrayList<>(),
                consumerList = new CopyOnWriteArrayList<>();

        Generator<Fat> fatGenerator = BasicGenerator.create(Fat.class);

        exec.execute(new ExchangerProducer<Fat>(fatGenerator, xc, producerList));
        exec.execute(new ExchangerConsumer<Fat>(xc, consumerList));

        TimeUnit.SECONDS.sleep(10);
        exec.shutdown();
    }
}
