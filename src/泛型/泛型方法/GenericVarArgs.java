package 泛型.泛型方法;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ycz on 2018/8/16.
 */
public class GenericVarArgs {
    public static <T> List<T> makeList(T ... args) {
        List<T> result = new ArrayList<T>();
        for (T arg : args) {
            result.add(arg);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> ls = makeList("A");
        System.out.println(ls);

        ls = makeList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
        System.out.println(ls);
    }
}
