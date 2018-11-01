package 容器.理解Map;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

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
        map.putAll(new CountingMapData(25)); // {0=0, 1=A0, 2=B0, 3=C0, 4=D0, 5=E0, 6=F0, 7=G0, 8=H0, 9=I0, 10=J0, ...}
        map.putAll(new CountingMapData(25));

        printKey(map);

        System.out.println("Values: ");
        System.out.println(map.values());


        map.putAll(new CountingMapData(25));
        map.keySet().removeAll(map.keySet());
        System.out.println("map.isEmpty() : " + map.isEmpty());

        System.out.println(map.values());

        System.out.println();
    }

    public static void main(String[] args) {
        test(new HashMap<Integer, String>());
        test(new LinkedHashMap<Integer, String>());
        test(new TreeMap<Integer, String>());
        test(new IdentityHashMap<Integer, String>());
        test(new ConcurrentHashMap<Integer, String>());
        test(new WeakHashMap<Integer, String>());
    }
}
