package 内部类.在方法和作用域内的内部类.练习;

/**
 * Created by ycz on 2017/12/6 0006.
 */
public class Outer5Test {
    public static void main(String[] args) {
        Outer5 outer5 = new Outer5();
        SimpleInteface simpleInteface = outer5.get();
        simpleInteface.f();
        System.out.println(simpleInteface.flag);
//        Outer5.Inner inner1 = (Outer5.Inner)simpleInteface;
//        inner1.f();


        simpleInteface = outer5.get2(); // get2 返回Inner，被upcast了，能看到的是接口的属性
        simpleInteface.f();
        System.out.println(simpleInteface.flag);
        // 修改Inner为public，观察以下代码
//        Outer5.Inner inner = (Outer5.Inner) simpleInteface;
//        inner.f();
//        System.out.println(inner.flag);

//        simpleInteface.getClassName();
//        Outer5.Inner inner2 = outer5.get2();
//        inner2.f();
    }
}
