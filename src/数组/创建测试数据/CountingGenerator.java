package 数组.创建测试数据;

import 数组.Generator;

public class CountingGenerator {
    public static class Boolean implements Generator<java.lang.Boolean> {

        private boolean value = false;

        @Override
        public java.lang.Boolean next() {
            value = !value;
            return value;
        }


    }

    public static class Byte implements Generator<java.lang.Byte> {

        private byte value = 0;

        @Override
        public java.lang.Byte next() {
            return value++;
        }
    }

    public static class Integer implements Generator<java.lang.Integer> {

        private int value = 0;

        @Override
        public java.lang.Integer next() {
            return value++;
        }
    }

    static char[] chars = ("abcdefghijklmnopqrstABCDEFGHIJKLMNOPQRST").toCharArray();

    public static class Character implements Generator<java.lang.Character> {

        int index = -1;

        @Override
        public java.lang.Character next() {
            index = (index + 1) % chars.length;
            return chars[index];
        }
    }

    public static class String implements Generator<java.lang.String> {
        private int length = 7;

        Generator<java.lang.Character> gn = new Character();

        public String() {
        }

        public String(int length) {
            this.length = length;
        }

        @Override
        public java.lang.String next() {
            char[] buf = new char[this.length];
            for (int i = 0; i < this.length; i++) {
                java.lang.Character character = gn.next();
                buf[i] = character;
            }
            return new java.lang.String(buf);
        }
    }

    public static class Double implements Generator<java.lang.Double> {

        private double value = 0.0;

        @Override
        public java.lang.Double next() {
            double result = value;
            value += 1.0;
            return result;
        }
    }
}

