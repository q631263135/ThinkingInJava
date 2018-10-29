package 容器.Set和存储顺序;

import 练习.Printer;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by ycz on 2018/10/25.
 */
public class SortedSetDemo {

    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<>();

        Collections.addAll(sortedSet,
                "one two three four five six seven eight".split(" "));

        Printer.println(sortedSet, "打印sortedSet：");

        String low = sortedSet.first();
        String high = sortedSet.last();

        Printer.println(low, "sortedSet.first() : ");
        Printer.println(high, "sortedSet.last() : ");

        Iterator<String> iterator = sortedSet.iterator();
        for (int i = 0; i < 7; i++) {
            if (i == 3) {
                low = iterator.next();
            }

            if (i == 6) {
                high = iterator.next();
            }

            else {
                iterator.next();
            }
        }
        Printer.println(low);
        Printer.println(high);

        Printer.println(sortedSet.subSet(low, high), "sortedSet.subSet(low, high) : ");
    }

}
