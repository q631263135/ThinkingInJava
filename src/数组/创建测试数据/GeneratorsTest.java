package 数组.创建测试数据;

import 数组.Generator;

import java.util.Random;

/**
 * Created by ycz on 2018/8/7.
 */
public class GeneratorsTest {
    public static int size = 10;

    public static void test(Class<?> surroundingClass) {
        for (Class<?> type : surroundingClass.getClasses()) { // ✔ getClasses
            System.out.print(type.getSimpleName() + ":");
            try {
                Generator<?> gn = (Generator<?>) type.newInstance();
                for (int i = 0; i < size; i++) {
                    System.out.printf(gn.next() + " ");
                }
                System.out.println();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
//        test(CountingGenerator.class);
//        test(RandomGenerator.class);
        Random rd = new Random(33);
        System.out.println(rd.nextDouble()); // 0.7280116037950541 ✔ 更高的精度
        System.out.println(rd.nextFloat()); // 0.8355015

        System.out.println(Math.round(rd.nextDouble()));

    }
}
