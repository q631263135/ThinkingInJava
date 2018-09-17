package 泛型.擦除;

import java.util.ArrayList;

/**
 * Created by ycz on 2018/8/22.
 */
public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2);

        Class<? extends ArrayList> c11 = new ArrayList<String>().getClass();
        Class<? extends ArrayList> c22 = new ArrayList<Integer>().getClass();
        System.out.println(c11 == c22);

        System.out.println(c1.getSimpleName());
        System.out.println(c2.getSimpleName());
        System.out.println(c11.getSimpleName());
        System.out.println(c22.getSimpleName());

    }
}
