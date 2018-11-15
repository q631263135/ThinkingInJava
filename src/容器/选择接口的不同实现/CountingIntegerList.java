package 容器.选择接口的不同实现;

import java.util.AbstractList;

/**
 * Created by ycz on 2018/11/15.
 */
public class CountingIntegerList extends AbstractList<Integer> {

    private int size;

    public CountingIntegerList(int size) {

        this.size = size < 0 ? 0 : size;

    }

    public Integer get(int index) {

        return Integer.valueOf(index);

    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {

        System.out.println(new CountingIntegerList(30));

    }

}