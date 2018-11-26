package 容器.实用方法;

import java.util.*;

/**
 * Created by ycz on 2018/11/23.
 */
public class Utilities {

    static List<String> list = Arrays.asList("one Two three Four five six one".split(" "));

    public static void main(String[] args) {
        System.out.println(list);

        System.out.println("'list' disjoint (four)?: " + Collections.disjoint(list, Collections.singletonList("four")));

        System.out.println("max: " + Collections.max(list));
        System.out.println("min: " + Collections.min(list));
        System.out.println("max w/ comparator: " + Collections.max(list, String.CASE_INSENSITIVE_ORDER));
        System.out.println("min w/ comparator: " + Collections.min(list, String.CASE_INSENSITIVE_ORDER));

        List<String> sublist = Arrays.asList("Four five six".split(" "));
        System.out.println("indexOfSublist: " + Collections.indexOfSubList(list, sublist));
        System.out.println("lastIndexOfSublist: " + Collections.lastIndexOfSubList(list, sublist));

        Collections.replaceAll(list, "one", "Yo");
        System.out.println("after replaceAll: " + list);


        Collections.reverse(list);
        System.out.println(list);

        Collections.rotate(list, 3);
        System.out.println(list);

        List<String> source = Arrays.asList("in the matrix".split(" "));
        Collections.copy(list, source);
        System.out.println("copy: " + list);

        Collections.swap(list, 0, list.size() - 1);
        System.out.println("swap: " + list);

        Collections.shuffle(list, new Random(47));
        System.out.println("shuffle: " + list);

        Collections.fill(list, "pop");
        System.out.println("fill: " + list);
        System.out.println("frequency of 'pop': " + Collections.frequency(list, "pop"));

        List<String> dups = Collections.nCopies(3, "snap");
        System.out.println("dups: " + dups);
        String s = dups.get(0);
        s = "abc";
        System.out.println("dups: " + dups);



//        List<String> dups2 = new ArrayList<>();
//        dups2.add("snap");
//        dups2.add("snap");
//        dups2.add("snap");
//        String s2 = dups2.get(0); // 定义一个s2(引用类型），指向dup2.get(0)
//        s2 = "abc"; // s2重新指向字符串abc
//        System.out.println("dups2: " + dups2);
//
//        if (dups2.get(0) == "snap") {
//            System.out.println("dups2.get(0) == \"snap\"");
//        }
//
//        String snap = new String("snap");
//        if (dups.get(0) == snap) {
//            System.out.println("dups.get(0) == snap");
//        }


    }
}
