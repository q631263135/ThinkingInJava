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

    static Map<String, String> map = new FlyweightMap();

    public static Map<String, String> capitals() {
        return map;
    }

    public static Map<String, String> capitals(int size) {
        return select(size);
    }

    private static class FlyweightMap extends AbstractMap<String, String> {

        @Override
        public Set<Entry<String, String>> entrySet() {
            return null;
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

}
