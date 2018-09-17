package 容器.List的功能方法;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by ycz on 2018/9/5.
 */
public class Lists {
    private static boolean b;
    private static String s;
    private static int i;
    private static Iterator<String> it;
    private static ListIterator<String> lit;

    public static void iterMotion(List<String> a) {
        ListIterator<String> lit = a.listIterator();
        b = lit.hasNext();
        b = lit.hasPrevious();
        s = lit.next();
        i = lit.nextIndex();
        s = lit.previous();
        i = lit.previousIndex();
    }
}
