package 泛型.泛型接口;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by ycz on 2018/8/14.
 */
// public class CoffeGenerator<Coffee>
public class CoffeGenerator implements Generator<Coffee>, Iterable<Coffee> {

    private Class[] types = {Breve.class, Mocha.class, Cappuccino.class};

    private static Random rand = new Random(99);

    private int size = 0;

    public CoffeGenerator() {
    }

    public CoffeGenerator(int size) {
        this.size = size;
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) types[rand.nextInt(types.length)].newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        CoffeGenerator coffeeGen = new CoffeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(coffeeGen.next());
        }


        for (Coffee c : new CoffeGenerator(5)) {

        }
    }


    // 迭代器

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    // class CoffeeIterator<Coffee> 会报错
    class CoffeeIterator implements Iterator<Coffee> {

        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeGenerator.this.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
