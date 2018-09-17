package 容器.可选操作;

import java.util.*;

/**
 * Created by ycz on 2018/9/5.
 */
public class Unsupported {
    static void test(String msg, List<String> list) {
        System.out.println("--- " + msg + " ---");
        Collection<String> c = list;
        Collection<String> subList = list.subList(1, 8);
        Collection<String> c2 = new ArrayList<String>(subList);

        try {
            c.retainAll(c2);
        } catch (Exception e) {
            System.out.println("retainAll: " + e);
        }

        try {
            c.clear();
        } catch (Exception e) {
            System.out.println("clear: " + e);
        }

        // add、addAll、remove

    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList(("A B C D E F G H I J K L").split(" "));
        test("Arrays.asList()", list);

        test("Modifiable Copy", Collections.unmodifiableList(new ArrayList<String>(list)));
    }
}
