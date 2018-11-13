package 容器.散列和散列码.覆盖hashCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ycz on 2018/11/8.
 */
public class CountedString {
    private static List<String> created = new ArrayList<>();

    private String s;
    private int id = 0;

    public CountedString(String s) {
        this.s = s;
        created.add(s);

        for (String s2 : created) {
            if (s2.equals(s)) {
                id++;
            }
        }
    }

    @Override
    public String toString() {
        return "CountedString{" +
                "s='" + s +
                "', id=" + id +
                ", hashCode():" + hashCode() + "}";
    }

    // hashCode基于类的的id和s域生成
    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + s.hashCode();
        result = 37 * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CountedString &&
                s.equals(((CountedString) obj).s) &&
                id == ((CountedString) obj).id;
    }

    public static void main(String[] args) {
        Map<CountedString, Integer> m = new HashMap<>();
        CountedString[] cs = new CountedString[5];

        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("hi");
            m.put(cs[i], i);
        }

        System.out.println(m);

        for (CountedString cstring : cs) {
            System.out.println("Looking up " + cstring);
            System.out.println(m.get(cstring));
        }
    }
}
