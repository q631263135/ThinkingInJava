package 泛型.泛型接口;

import java.util.Iterator;

/**
 * Created by ycz on 2018/8/15.
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    private int n;

    public IterableFibonacci(int n) {
        this.n = n;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return IterableFibonacci.this.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
