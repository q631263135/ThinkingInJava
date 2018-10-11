package 容器.填充容器;

import java.util.*;

/**
 * Created by ycz on 2018/8/30.
 */

// TODO
public class Countries {
    public static final String[][] DATA = {
            {"河北省", "冀"},
            {"山东省", "齐"},
            {"辽宁省", "辽"},
            {"黑龙江省", "黑"},
            {"吉林省", "吉"},
            {"甘肃省", "陇"},
            {"青海省", "青"},
            {"河南省", "豫"},
            {"江苏省", "苏"},
            {"湖北省", "鄂"},
            {"湖北省", "湘"},
            {"江西省", "赣"},
            {"浙江省", "浙"},
            {"广东省", "粤"},
            {"云南省", "滇"},
            {"福建省", "福"},
            {"台湾省", "台"},
            {"海南省", "琼"},
            {"山西省", "晋"},
            {"四川省", "川"},
            {"陕西省", "陕"},
            {"贵州省", "黔"},
            {"安徽省", "皖"},
            {"重庆市", "重庆"},
            {"北京市", "北京"},
            {"上海市", "上海"},
            {"天津市", "天津"},
            {"广西壮族自治区", "广西"},
            {"内蒙古自治区", "内蒙"},
            {"新疆维吾尔自治区", "新疆"},
            {"西藏自治区", "西藏"},
            {"宁夏回族自治区", "宁夏"},
            {"澳门特别行政区", "澳门"},
            {"香港特别行政区", "香港"}
    };

    private static class FlyweightMap extends AbstractMap<String, String> {


        private static Set<Map.Entry<String, String>> entries = new EntrySet(DATA.length);

        @Override
        public Set<Entry<String, String>> entrySet() {
            System.out.println("调用了 entrySet");
            return entries;
        }

    }

    // Entry 二元组直接使用了数组
    static class Entry implements Map.Entry<String, String> {

        int index;

        public Entry(int index) {
            this.index = index;
        }

        @Override
        public String getKey() {
            return DATA[index][0];
        }

        @Override
        public String getValue() {
            return DATA[index][1];
        }

        @Override
        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int hashCode() {
            return DATA[index][0].hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return DATA[index][0].equals(obj);
        }
    }

    // Entry Set 中没有声明 Entry，但在迭代器中访问了 Entry
    static class EntrySet extends AbstractSet<Map.Entry<String, String>> {

        private int size;

        EntrySet(int size) {
            if (size < 0) {
                this.size = 0;
            } else if (size > DATA.length) {
                this.size = DATA.length;
            } else {
                this.size = size;
            }
        }

        private class Iter implements Iterator<Map.Entry<String, String>> {

            private Entry entry = new Entry(-1);

            @Override
            public boolean hasNext() {
                return entry.index < size - 1;
            }

            @Override
            public Map.Entry<String, String> next() {
                entry.index++;
                return entry;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        @Override
        public Iterator<Map.Entry<String, String>> iterator() {
            System.out.println("使用迭代器打印 entry");
            return new Iter();
        }

        @Override
        public int size() {
            return size;
        }
    }

    // 通过指定 size，返回可以 访问指定数目的 Entry（通过直接访问数组实现）
    static Map<String, String> select(final int size) {
        return new FlyweightMap() {
            public Set<Map.Entry<String, String>> entrySet() {
                return new EntrySet(size);
            }
        };
    }

    static Map<String, String> map = new FlyweightMap();

    public static Map<String, String> capitals() {
        return map;
    }

    public static Map<String, String> capitals(int size) {
        return select(size);
    }

    // 这个 map 中，其实啥也没装
    static List<String> names = new ArrayList<>(map.keySet());

    public static List<String> names() {
        return names;
    }

    public static List<String> names(int size) {
        return new ArrayList<>(select(size).keySet());
    }

    public static void main(String[] args) {
        System.out.println(capitals());
    }
}
