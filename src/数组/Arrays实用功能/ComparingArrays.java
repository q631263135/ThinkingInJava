package 数组.Arrays实用功能;

import java.util.Arrays;

/**
 * Created by ycz on 2018/8/10.
 */
public class ComparingArrays {
    public static void main(String[] args) {
        int[] a1 = new int[10];
        int[] a2 = new int[10];

        Arrays.fill(a1, 33);
        Arrays.fill(a2, 33);

        System.out.println(Arrays.equals(a1, a2));

        a2[3] = 11;

        System.out.println(Arrays.equals(a1, a2));

        String s1[] = new String[4];
        String s2[] = new String[4];

        Arrays.fill(s1, "Hi");
        Arrays.fill(s2, new String("Hi"));

        System.out.println(Arrays.equals(s1, s2));

    }
}
