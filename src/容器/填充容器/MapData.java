package 容器.填充容器;

import 泛型.泛型接口.Generator;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Created by ycz on 2018/8/29.
 */
class Pair<K, V> {
    public final K key;
    public final V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

class Letters implements Generator<Pair<Integer, String>>, Iterable<Integer> {

    private int size = 9;

    private int number = 1;

    private char letter = 'A';

    @Override
    public Pair<Integer, String> next() {
        return new Pair<>(number++, "" + letter++);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return number < size;
            }

            @Override
            public Integer next() {
                return number++;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}

public class MapData<K, V> extends LinkedHashMap<K, V> {

    public MapData(Generator<Pair<K, V>> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Pair<K, V> p = gen.next();
            put(p.key, p.value);
        }
    }

    public MapData(Generator<K> genK, Generator<V> genV, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(genK.next(), genV.next());
        }
    }

    public MapData(Iterable<K> genK, V value) {
        for (K key : genK) {
            put(key, value);
        }
    }

    // test
    public static void main(String[] args) {
        // Unchecked call to 'MapData(Generator<Pair<K, V>>, int)' as a member of raw type '容器.填充容器.MapData'
        System.out.println(new MapData(new Letters(), 5));

        // Explicit type argument Integer, String can be replaced with <>
        System.out.println(new MapData<Integer, String>(new Letters(), "abc"));


        MapData<Integer, String> integerStringMapData = new MapData<>(new Letters(), 5);
    }
}
