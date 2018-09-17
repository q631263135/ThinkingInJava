package 泛型.泛型方法;

import 泛型.简单泛型.一个元组类库.TwoTuple;

/**
 * Created by ycz on 2018/8/16.
 */
public class TupleTest2 {
    static TwoTuple<String, Integer> f() {
        return Tuple.tuple("hi", 47);
    }

    static TwoTuple f2() {
        return Tuple.tuple("hi", 47);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> twoTuple = f();
        System.out.println(twoTuple);

        TwoTuple twoTuple2 = f2();

        System.out.println(twoTuple2);
    }
}
