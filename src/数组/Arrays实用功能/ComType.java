package 数组.Arrays实用功能;

import 数组.Generator;
import 数组.从Generator中创建数组.Generated;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by ycz on 2018/8/10.
 */
public class ComType implements Comparable<ComType> {
    int i, j;
    private static int count = 1;

    public ComType(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public int compareTo(ComType o) {
        return i < o.i ? -1 : (i == o.i ? 0 : 1);
    }

    @Override
    public String toString() {

        String result = "ComType{" +
                "i=" + i +
                ", j=" + j +
                '}';
        if (count++ % 3 == 0) {
            result += "\n";
        }
        return result;
    }

    static Random rd = new Random(47);

    public static Generator<ComType> generator() {
        return new Generator<ComType>() {
            @Override
            public ComType next() {
                return new ComType(rd.nextInt(100), rd.nextInt(100));
            }
        };
    }

    public static void main(String[] args) {
        ComType[] comTypes = Generated.array(new ComType[12], generator());
        System.out.println("before sorting:");
        System.out.println(Arrays.toString(comTypes));

        System.out.println("after sorting:");
        Arrays.sort(comTypes);
        System.out.println(Arrays.toString(comTypes));

    }


}
