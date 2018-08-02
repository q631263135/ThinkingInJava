package 内部类.使用点this和点new;

/**
 * Created by Administrator on 2017/10/25 0025.
 */
public class DotNew {
    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.Inner inner = dt.new Inner();
        inner.outer().f();
    }
}
