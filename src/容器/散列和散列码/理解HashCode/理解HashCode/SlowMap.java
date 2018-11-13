package 容器.散列和散列码.理解HashCode.理解HashCode;

import 容器.散列和散列码.MapEntry;

import java.util.*;

/**
 * Created by Administrator on 2018/9/20 0020.
 */
public class SlowMap<K, V> extends AbstractMap<K, V> {

    private List<K> keys = new ArrayList<K>();
    private List<V> values = new ArrayList<V>();

    @Override
    public Set<Entry<K, V>> entrySet() { // remove "<K, V>" : attempting to use incompatible return type
        Set<Entry<K, V>> set = new HashSet<>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();

        while (ki.hasNext()) {
            set.add(new MapEntry<>(ki.next(), vi.next()));
        }

        return set;
    }

    public V put(K key, V value) {
        V oldValue = get(key);

        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else {
            values.set(keys.indexOf(key), value);
        }

        return oldValue;
    }

    public V get(Object key) { // change the "Object" to "K" : both methods have same erasure, yet neither overrides the other
        if (!keys.contains(key)) {
            return null;
        }
        return values.get(keys.indexOf(key));
    }

    public static void main(String[] args) {
        SlowMap<String, String> m = new SlowMap<>();
        m.put("安徽", "合肥");
        m.put("河南", "郑州");
        m.put("浙江", "杭州");
        m.put("黑龙江", "哈尔滨");
        m.put("山东", "济南");
        System.out.println(m.toString());
        System.out.println(m.entrySet());
    }
}
