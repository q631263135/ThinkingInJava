package 内部类.匿名内部类;

import 内部类.内部类与向上转型.IDestination;

/**
 * Created by ycz on 2017/12/13 0013.
 */
interface Contents {
    int value();
}

public class Parcel7 {
    public Contents contents() {
        return new Contents() { // 创建一个继承自Contents的匿名类对象
            private int i = 11;
            public int value() {
                return i;
            }
        };
    }

    public IDestination destination() {
        return new IDestination() {
            @Override
            public String readLabel() {
                return null;
            }
        };
    }

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        p.contents();
    }
}
