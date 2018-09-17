package 数组.Arrays实用功能;

import java.util.Arrays;

/**
 * Created by ycz on 2018/8/10.
 */
public class CopyingArrays {

    public static void main(String[] args) {
        int[] i = new int[7];
        int[] j = new int[10];

        Arrays.fill(i, 47);
        Arrays.fill(j, 99);

        System.out.println("before copy...");
        System.out.println("i = " + Arrays.toString(i));
        System.out.println("j = " + Arrays.toString(j));

        System.out.println("after copy...");
        System.arraycopy(i, 0, j, 0, i.length);
        System.out.println("i = " + Arrays.toString(i));
        System.out.println("j = " + Arrays.toString(j));

        Integer[] u = new Integer[10];
        Integer[] v = new Integer[5];
        Arrays.fill(u, new Integer(23));
        Arrays.fill(v, new Integer(55));
        System.out.println("u = " + Arrays.toString(u));
        System.out.println("v = " + Arrays.toString(v));

        System.arraycopy(v, 0, u, 0, v.length);
        System.out.println("u = " + Arrays.toString(u));
        System.out.println("v = " + Arrays.toString(v));

        System.out.println(u[0].equals(v[0]));
        u[0] = 34;
        System.out.println(u[0].equals(v[0]));
        System.out.println("u = " + Arrays.toString(u));
        System.out.println("v = " + Arrays.toString(v));
    }
}
