package 容器.填充容器;

import 数组.Generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Queue;

/**
 * Created by ycz on 2018/8/28.
 */
class Government implements Generator<String> {
    String[] foundation = ("Strange women lying in ponds").split(" ");

    private int index;

    @Override
    public String next() {
        return foundation[index++];
    }
}

public class CollectionData<T> extends ArrayList<T> {

    public CollectionData(Generator<T> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            T next = gen.next();
            add(next);
        }
    }

    public static <T> CollectionData list(Generator<T> gen, int quantity) {
        return new CollectionData(gen, quantity);
    }

    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<>(new CollectionData<String>(new Government(), 3));
        System.out.println(set);


        CollectionData list = CollectionData.list(new Government(), 5);
        set.addAll(list);
        System.out.println(set);


    }
}
