package 数组.创建测试数据;

import 数组.Generator;

import java.util.Random;

/**
 * Created by ycz on 2018/8/8.
 */
public class RandomGenerator {
    private static Random rd = new Random(47);

    public static class Boolean implements Generator<java.lang.Boolean> {
        @Override
        public java.lang.Boolean next() {
            return rd.nextBoolean();
        }
    }

    public static class Byte implements Generator<java.lang.Byte> {
        @Override
        public java.lang.Byte next() {
            return (byte) rd.nextInt();
        }
    }

    public static class Character implements Generator<java.lang.Character> {


        @Override
        public java.lang.Character next() {
            return CountingGenerator.chars[rd.nextInt(CountingGenerator.chars.length)];
        }
    }

    public static class String extends CountingGenerator.String {
        {
            gn = new Character();
        }

        public String() {
        }

        public String(int length) {
            super(length);
        }
    }
}
