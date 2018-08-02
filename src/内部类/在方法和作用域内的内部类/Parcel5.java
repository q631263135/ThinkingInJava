package 内部类.在方法和作用域内的内部类;

import 内部类.内部类与向上转型.IDestination;
import 内部类.创建内部类.Parcel1;

/**
 * 方法作用域内的内部类
 * Created by ycz on 2017/12/6 0006.
 */
public class Parcel5 {

    int i = 99;

    public IDestination dest(String s) {

        /**
         * 我个人认为这种做法是把原本结构化处理的代码，用面向对象的方式表达出来，可以利用面向对象的优点去处理问题
         */

        class PDestination implements IDestination {

            private String label;

            public PDestination(String whereTo) {
                System.out.println(Parcel5.this.i); // look this
                this.label = whereTo;
            }

            @Override
            public String readLabel() {
                return label;
            }
        }

        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel5 p5 = new Parcel5();
        IDestination dest_Cangnan = p5.dest("cangnan");
        System.out.println(dest_Cangnan.readLabel());

//        PDestination pDestination = p5.new PDestination(); // Cannot resolve symbol 'PDestination'
    }
}
/*
output:
99
cangnan*/
