package 内部类.使用点this和点new;

/**
 * Created by Administrator on 2017/10/25 0025.
 */
public class DotThis {
    public void f() {
        System.out.println("DotThis.f()");
    }

    public class Inner {
        public DotThis outer() {
            return DotThis.this;
        }
    }

    public Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        Inner inner = dt.inner();
        inner.outer().f();
    }
}
