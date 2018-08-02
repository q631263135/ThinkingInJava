package 练习.Java值传递;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ycz on 2018/1/9 0009.
 */
public class A1819 {
    private B1819 b1819;

    private List<B1819> list;

    public B1819 getB1819() {
        return b1819;
    }

    public void setB1819(B1819 b1819) {
        this.b1819 = b1819;
    }

    public List<B1819> getList() {
        return list;
    }

    public void setList(List<B1819> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "A1819{" +
                "b1819=" + b1819 +
                ", list=" + list +
                '}';
    }

    public List<B1819> retList() {
        B1819 b1819 = new B1819(2);
        List<B1819> b1819s = new ArrayList<B1819>();
        return b1819s;
    }

    public static void main(String[] args) {
        A1819 a1819 = new A1819();
        List<B1819> lst = new ArrayList<B1819>();
        a1819.setList(lst);

        lst.add(new B1819(1));

        lst = a1819.retList();

        // 起初我认为先执行 a1819.setList(lst); 再给 lst 赋值的方式改变 a1819 的属性
        // 我的理由是它们指向同一个引用
        // 而事实并非如此

        System.out.println(a1819.toString());

        B1819 b1819 = new B1819(3);
        a1819.setB1819(b1819);

        b1819 = new B1819(4);

        System.out.println(a1819.toString());
    }
}
