package 内部类.创建内部类;

/**
 * Created by Administrator on 2017/10/25 0025.
 */
public class Parcel1 {

    private String name;

    public Parcel1(String name) {
        this.name = name;
    }

    // 这是一个内部类
    class Contents {
        private int i = 11;
        public  int value() {
            return i;
        }
    }
    public class Destination {
        private String label;
        Destination(String whereTo) {
            label = whereTo;
        }
        String readLabel() {
            System.out.println(Parcel1.this.name);
            return label;
        }
    }

    public void ship(String dest) {
        Contents c = new Contents();

        Destination d = new Destination(dest);
        System.out.println(d.readLabel());

        Parcel1.Destination d2 = new Parcel1.Destination(dest);
        System.out.println(d2.readLabel());

        // 下面是最新增加的代码
        Destination d3 = this.new Destination(dest);
        System.out.println(d3.readLabel());
    }

    public static void main(String[] args) {
        Parcel1 p = new Parcel1("yangchaozheng");
        p.ship("shanghai");

//        Destination destination = p.new Destination("cangnan");
//        System.out.println(destination.readLabel());

        // Destination d = new Destination(); // '内部类.创建内部类.Parcel1.this' cannot be referenced from a static context
        // Parcel1.Destination d1 = new Destination(); // '内部类.创建内部类.Parcel1.this' cannot be referenced from a static context
    }
}
/*
Output:
shanghai
 */