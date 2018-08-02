package 内部类.在方法和作用域内的内部类.练习;

/**
 * Created by ycz on 2017/12/6 0006.
 */
public class Main {
    boolean flag = true;

    public InterfaceX mainMethodX() {
        class ClassX implements InterfaceX {
            @Override
            public void methodX() {
                System.out.println("hahaha");
            }
        }
        return new ClassX();
    }

    public void add() {
        while (flag) {
            class ClassX implements InterfaceX {
                int result;

                @Override
                public void methodX() {
                    System.out.println(this.result);
                }
                public void add(int x, int y) {
                    result = x + y;
                }
            }

            ClassX classX = new ClassX();
            classX.add(7, 8);
            System.out.println(classX.result);

            Main.this.flag = false;
//            flag = false; 外部对象的属性可以控制内部类执行过程，细思饶有趣味（就像两台机器在协同运作一样，并联想单片机的一些东西）
        }

    }

    public static void main(String[] args) {
        Main m = new Main();
        InterfaceX interfaceX = m.mainMethodX();
        interfaceX.methodX();

        m.add();
    }
}
