package 容器.填充容器;

import java.util.*;

/**
 * Created by ycz on 2018/8/30.
 */

// TODO
public class Countries {
    public static final String[][] DATA = {
            {"AA", "A"},
            {"BB", "B"},
            {"CC", "C"},
            {"DD", "D"},
            {"EE", "E"},
            {"FF", "F"}
    };

    private static class FlyweightMap extends AbstractMap<String, String> {


        @Override
        public Set<Map.Entry<String, String>> entrySet() {
            return null;
        }

        private static class Entry implements Map.Entry<String, String> {

            int index;
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
            public boolean equals(Object obj) {
                return DATA[index][0].equals(obj);
            }

            @Override
            public int hashCode() {
                return DATA[index][0].hashCode();
            }
        }
    }

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

        @Override
        public Iterator<Map.Entry<String, String>> iterator() {
            return null;
        }

        @Override
        public int size() {
            return size;
        }
    }

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

}
