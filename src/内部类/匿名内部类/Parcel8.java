package 内部类.匿名内部类;

/**
 * Created by ycz on 2017/12/13 0013.
 */
public class Parcel8 {
    public Wrapping getWrapping(int i) {
        return new Wrapping(i) {
            private int i;
            public int value() {
                return super.value() + 33;
            }
        };
    }

    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        System.out.println(p.getWrapping(10).value());
    }
}
