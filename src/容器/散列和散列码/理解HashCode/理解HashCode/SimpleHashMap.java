package 容器.散列和散列码.理解HashCode.理解HashCode;

import 容器.散列和散列码.MapEntry;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Administrator on 2018/9/28 0028.
 */
public class SimpleHashMap<K, V> extends AbstractMap<K, V> {

    static final int SIZE = 997;

    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
