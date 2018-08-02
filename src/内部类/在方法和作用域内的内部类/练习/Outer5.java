package 内部类.在方法和作用域内的内部类.练习;

import 内部类.使用点this和点new.DotThis;

import javax.sound.midi.Soundbank;

/**
 * Created by ycz on 2017/12/6 0006.
 */
public class Outer5 {

//    public class Inner implements SimpleInteface {
    private class Inner implements SimpleInteface {

        public int flag = 1;

        private String className = "Inner";

        public String getClassName() {
            return className;
        }

        @Override
        public void f() {
            System.out.println("Outer5.Inner.f");
        }
    }

    public SimpleInteface get() {
        return new Inner();
    }

    public Inner get2() {
        return new Inner();
    }

    public static void main(String[] args) {
        Outer5 outer5 = new Outer5();
        SimpleInteface simpleInteface = outer5.get();
        simpleInteface.f();

        Inner inner1 = (Inner)simpleInteface;
        inner1.f();


        simpleInteface = outer5.get2();
        simpleInteface.f();
        Inner inner2 = outer5.get2();
        inner2.f();
    }
}
