package 容器.理解Map;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * Created by ycz on 2018/11/1.
 */
public class SortedMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer, String> sortedMap = new TreeMap<>(new CountingMapData(10));

        System.out.println(sortedMap);

        Integer firstKey = sortedMap.firstKey();
        Integer lastKey = sortedMap.lastKey();
        System.out.println("firstKey = " + firstKey);
        System.out.println("lastKey = " + lastKey);

        Iterator<Integer> it = sortedMap.keySet().iterator();
        for (int i = 0; i <= 6 ; i++) {
            if (i == 3) firstKey = it.next();
            if (i == 6) lastKey = it.next();
            else it.next();
        }

        System.out.println(sortedMap.subMap(firstKey, lastKey));
    }
}
