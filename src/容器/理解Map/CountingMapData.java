package 容器.理解Map;

import java.util.AbstractMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ycz on 2018/10/31.
 */
public class CountingMapData extends AbstractMap<Integer, String> {
    private int size;
    private static String[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

    public CountingMapData(int size) {
        this.size = (size < 0 ? 0 : size);
    }

    private static class Entry implements Map.Entry<Integer, String> {

        int index;

        public Entry(int index) {
            this.index = index;
        }

        @Override
        public boolean equals(Object obj) {
            return Integer.valueOf(index).equals(obj);
        }

        @Override
        public Integer getKey() {
            return index;
        }

        @Override
        public String getValue() {
//            System.out.println("index : " + index);
//            System.out.println("chars[index % chars.length] : " + chars[index % chars.length]);
//            System.out.println("index / chars.length : " + index / chars.length);
            return chars[index % chars.length] + Integer.toString(index / chars.length);
        }

        @Override
        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int hashCode() {
            return Integer.valueOf(index).hashCode();
        }

    }

    @Override
    public Set<Map.Entry<Integer, String>> entrySet() {
        Set<Map.Entry<Integer, String>> entries = new LinkedHashSet<>();
        for (int i = 0; i < size; i++) {
            entries.add(new Entry(i));
        }

        return entries;
    }


    public static void main(String[] args) {
        System.out.println(new CountingMapData(30));
//        System.out.println(1 / 27);
//        System.out.println(1 % 27);
//        System.out.println(2.0 / 27);
//        System.out.println(2 % 27);
//
//        toString→entrySet→getKey→getValue
//        entry的value在外部，实际getValue时在计算得出
    }
}
