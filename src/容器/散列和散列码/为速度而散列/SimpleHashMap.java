package 容器.散列和散列码.为速度而散列;

import 容器.填充容器.Countries;
import 容器.散列和散列码.MapEntry;

import java.util.*;

/**
 * Created by ycz on 2018/11/7.
 */
public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
    static final int SIZE = 997;

    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;

        // 如果当前index所在的链表为空，则新建链表
        // 否则，访问该链表，并查找key
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        // 当前链表不为空，下面这部分代码会“实际”执行
        LinkedList<MapEntry<K, V>> bucket = buckets[index];

        MapEntry<K, V> pair = new MapEntry<>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> iterator = bucket.listIterator();

        while (iterator.hasNext()) {
            MapEntry<K, V> next = iterator.next();
            if (next.getKey().equals(key)) {
                oldValue = next.getValue();
                iterator.set(pair);
                found = true;
                break;
            }
        }
        // ~

        if (!found) {
            buckets[index].add(pair);
        }
        return oldValue;

    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) {
                continue;
            }

            for (MapEntry<K, V> pair : bucket) {
                set.add(pair);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        SimpleHashMap<String, String> m = new SimpleHashMap<>();
        m.putAll(Countries.capitals(10));

        System.out.println(m);
    }
}
