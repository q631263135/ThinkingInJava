package 容器.理解Map;

import java.util.LinkedHashMap;

/**
 * Created by ycz on 2018/11/1.
 */
public class LinkedHashMapDeamo {
    public static void main(String[] args) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(new CountingMapData(9));
        System.out.println(linkedHashMap);

        // Least-recently-used order:
        linkedHashMap = new LinkedHashMap(16, 0.75f, true);
        linkedHashMap.putAll(new CountingMapData(9));
        System.out.println(linkedHashMap);

        for (int i = 0; i < 6; i++) {
            linkedHashMap.get(i);
        }
        System.out.println(linkedHashMap);

        linkedHashMap.get(0);
        System.out.println(linkedHashMap);

        linkedHashMap.get(7);
        System.out.println(linkedHashMap);


    }
}
