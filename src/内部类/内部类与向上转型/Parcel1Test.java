package 内部类.内部类与向上转型;

/**
 * Created by Administrator on 2017/10/25 0025.
 */
public class Parcel1Test {

    public static void main(String[] args) {
        Parcel1 p = new Parcel1();
        p.ship("wenzhou");
        IDestination destination = p.new Destination("cangnan");
        Parcel1.Destination destCast = (Parcel1.Destination) destination;
        destCast.readLabel();

        IContents contents = p.getContents(555);
        p.m(contents);
        System.out.println(contents.value());
    }
}
