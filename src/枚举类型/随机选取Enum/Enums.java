package 枚举类型.随机选取Enum;

import java.util.Random;

/**
 * Created by ycz on 2017/12/28.
 */
public class Enums {
    private static Random rd = new Random(20);

    public static <T extends Enum<T>> T random(Class<T> clazz) {
        return random(clazz.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[rd.nextInt(values.length)];
    }

    public static void main(String[] args) {
        Random rd = new Random(20);
        System.out.println(rd.nextInt(3));
    }
}
