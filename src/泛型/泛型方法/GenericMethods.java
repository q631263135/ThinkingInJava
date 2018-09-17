package 泛型.泛型方法;

/**
 * Created by ycz on 2018/8/15.
 */
public class GenericMethods {

    public <T> void f(T x) {
        System.out.println("getName:" + x.getClass().getName() + ", getSimpleName:" + x.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();

        gm.f("");
        gm.f(1);
        gm.f(1.0);
        gm.f(1.0F);
        gm.f('c');
        gm.f(gm);
    }
}
