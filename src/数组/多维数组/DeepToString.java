package 数组.多维数组;

import java.util.Arrays;

/**
 * Created by ycz on 2018/8/6.
 */
class Girl {
    private String cupSize;

    private int age;

    private String name;

    public Girl(String cupSize, int age, String name) {
        this.cupSize = cupSize;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Gril{" +
                "cupSize=" + cupSize +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

public class DeepToString {
    public static void main(String[] args) {
        Girl[][] girls = {
                {new Girl("F", 15, "lili"), new Girl("B", 18, "jiaojiao")},
                {new Girl("A", 23, "yaoyao")},
                {}};
        System.out.println(girls.toString());
        System.out.println(Arrays.toString(girls));
        System.out.println(Arrays.deepToString(girls));
        ;
    }
}
