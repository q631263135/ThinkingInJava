package 容器.理解Map;

import java.util.Map;

/**
 * Created by ycz on 2018/10/31.
 */
public class Maps {
    public static void printKey(Map<Integer, String> map) {
        System.out.println("Size = " + map.size());
        System.out.println("Keys: " + map.keySet());
    }

    public static void test(Map<Integer, String> map) {
        System.out.println("map.getClass().getSimpleName():" + map.getClass().getSimpleName());
        map.putAll(new CountingMapData(25));
    }
}
