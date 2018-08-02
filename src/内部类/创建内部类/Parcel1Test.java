package 内部类.创建内部类;

/**
 * Created by Administrator on 2017/10/25 0025.
 */
public class Parcel1Test {

    public static void main(String[] args) {
        Parcel1 p = new Parcel1("yangchaozheng");
        p.ship("wenzhou");
        // Parcel1.Destination d = new Parcel1.Destination(); // '内部类.创建内部类.Parcel1' is not an enclosing class
        Parcel1.Destination destination = p.new Destination("cangnan");
    }
}
