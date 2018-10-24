package 容器.Set和存储顺序;

import 练习.Printer;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by ycz on 2018/10/24.
 */
public class TypesForSets {
    private static int counter;

    static <T> Set<T> fill(Set<T> set, Class<T> type) {
        for (int i = 0; i < 10; i++) {
            try {
                set.add(type.getConstructor(int.class).newInstance(i));
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        return set;

//        Printer.println(set);

//        if (counter++ == 2)
//            return set;
//        else
//            return fill(set, type);

    }

    static <T> void test(Set<T> set, Class<T> type) {
        fill(set, type);
        fill(set, type);

        System.out.println(set);
    }

    public static void main(String[] args) {
//        fill(new HashSet<HashType>(), HashType.class);
//        fill(new LinkedHashSet<HashType>(), HashType.class);
//        fill(new TreeSet<TreeType>(), TreeType.class);

        test(new HashSet<HashType>(), HashType.class);
        test(new LinkedHashSet<HashType>(), HashType.class);
        test(new TreeSet<TreeType>(), TreeType.class);

        // Things that don't work
        test(new HashSet<SetType>(), SetType.class);
        test(new HashSet<TreeType>(), TreeType.class);
        test(new LinkedHashSet<SetType>(), SetType.class);
        test(new LinkedHashSet<TreeType>(), TreeType.class);

        try {
            test(new TreeSet<SetType>(), SetType.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}


class SetType {
    int i;

    public SetType(int n) {
        i = n;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof SetType && (i == ((SetType)obj).i);
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}

class HashType extends SetType {

    // 如果父类没有提供默认的构造函数，则子类必须定义自己的构造函数
    public HashType(int n) {
        super(n);
    }

    @Override
    public int hashCode() {
        return i;
    }
}

class TreeType extends SetType implements Comparable<TreeType> {

    public TreeType(int n) {
        super(n);
    }

    @Override
    public int compareTo(TreeType o) {
        return o.i < i ? -1 : (o.i == i ? 0 : 1);
    }
}