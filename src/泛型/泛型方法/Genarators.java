package 泛型.泛型方法;

import 泛型.泛型接口.CoffeGenerator;
import 泛型.泛型接口.Coffee;
import 泛型.泛型接口.Fibonacci;
import 泛型.泛型接口.Generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * Created by ycz on 2018/8/15.
 */
class IntegerGenerator implements Generator<Integer> {

    @Override
    public Integer next() {
        return new Random().nextInt(100);
    }
}

public class Genarators {
    public static <T> Collection fill(Collection<T> coll, Generator<T> gen, int n) {

        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }

    public static void main(String[] args) {
        Collection<Coffee> coffee = fill(new ArrayList<Coffee>(), new CoffeGenerator(), 4);

        for (Coffee c : coffee) {
            System.out.println(c);
        }

        Collection<Integer> fnumbers = fill(new ArrayList<Integer>(), new Fibonacci(), 10);

        for (int i : fnumbers) {
            System.out.print(i + ", ");
        }
    }
}
