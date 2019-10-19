package 并发.新类库中的构件.Exchanger;

import 并发.新类库中的构件.Semaphore.Fat;
import 泛型.泛型接口.Generator;

/**
 * <br/>
 *
 * @author yangchaozheng
 * @date 2019/10/18 19:42
 */
public class BasicGenerator<T> implements Generator<T> {
    private Class<T> type;
    public BasicGenerator(Class<T> type){ this.type = type; }
    public T next() {
        try {
            // Assumes type is a public class:
            return type.newInstance();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    // Produce a Default generator given a type token:
    public static <T> Generator<T> create(Class<T> type) {
        return new BasicGenerator<T>(type);
    }
} ///:~