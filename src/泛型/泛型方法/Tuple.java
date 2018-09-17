package 泛型.泛型方法;

import 泛型.简单泛型.一个元组类库.ThreeTuple;
import 泛型.简单泛型.一个元组类库.TwoTuple;

/**
 * Created by ycz on 2018/8/16.
 */
public class Tuple {
    public static <A, B> TwoTuple tuple(A a, B b) {
        return new TwoTuple<A, B>(a, b);
    }

    public static <A, B, C> ThreeTuple tuple(A a, B b, C c) {
        return new ThreeTuple(a, b, c);
    }

}
