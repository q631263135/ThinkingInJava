package 容器.Collection的功能方法;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import 练习.Printer;
import 练习.SystemOutPrintln;

/**
 * Created by ycz on 2018/8/31.
 */
public class CollectionMethods {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("nine");
        c.add("ten");
        c.add("eleven");

        Printer.println(c); // 1
        Printer.println(Collections.max(c)); // 2

        Object[] array = c.toArray();
        String[] strArray = c.toArray(new String[0]);

        Collection<String> c2 = new ArrayList<>();
        c2.addAll(c);
        c.remove("nine");
        Printer.println(c); // 3
        Printer.println(c2); // 4

        c2.removeAll(c);
        Printer.println(c2); // 5

        c2.clear();
        Printer.println(c2); // 6
    }
}
