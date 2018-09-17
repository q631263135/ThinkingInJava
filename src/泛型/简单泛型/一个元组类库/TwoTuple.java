package 泛型.简单泛型.一个元组类库;

/**
 * Created by ycz on 2018/8/13.
 */
public class TwoTuple<A, B> {
    public final A first;
    public final B second;


    public TwoTuple(A first, B second) {
        System.out.println(first.getClass().getSimpleName());
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
