package 容器.Collection的功能方法;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by ycz on 2018/8/31.
 */
public class CollectionMethods {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("nine");
        c.add("ten");
        c.add("eleven");
        System.out.println(c);

        Object[] array = c.toArray();
        String[] strArray = c.toArray(new String[0]);

        System.out.println(Collections.max(c));

        Collection<String> c2 = new ArrayList<>();
        c2.addAll(c);

        System.out.println(c2);


        c.remove("nine");
        System.out.println(c);
        System.out.println(c2);

        c2.removeAll(c);
        System.out.println(c2);
        c2.clear();

        System.out.println(c2);
    }
}
