package 数组.从Generator中创建数组;

import 数组.Generator;
import 数组.创建测试数据.CountingGenerator;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ycz on 2018/8/8.
 */
public class Generated {
    public static <T> T[] array(T[] a, Generator<T> gen) {
        return new CollectionData<T>(gen, a.length).toArray(a); // ✔ public <T> T[] toArray(T[] a)
    }

    public static <T> T[] array(Class<T> type, Generator<T> gen, int size) {
        // 使用反射来动态创建具有恰当类型和数量的新数组
        T[] a = (T[]) java.lang.reflect.Array.newInstance(type, size);
        return new CollectionData<T>(gen, size).toArray(a);
    }

    public static void main(String[] args) {
        Integer[] a = {9, 8, 7, 6};
        System.out.println(Arrays.toString(a));
        a = array(a, new CountingGenerator.Integer());
        System.out.println(Arrays.toString(a));

        Integer[] b = array(Integer.class, new CountingGenerator.Integer(), 15);

        System.out.println(Arrays.toString(b));
    }
}

class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            add(gen.next());
        }
    }

    public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {
        return new CollectionData<T>(gen, quantity);
    }

}
