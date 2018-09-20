package 容器.散列和散列码.理解HashCode;

import 容器.填充容器.Countries;

import java.util.*;

/**
 * Created by Administrator on 2018/9/20 0020.
 */
public class SlowMap<k, v> extends AbstractMap<k, v> {

    private List<k> keys = new ArrayList<k>();
    private List<v> values = new ArrayList<v>();

    @Override
    public Set<Entry<k, v>> entrySet() { // remove "<k, v>" : attempting to use incompatible return type
        Set<Entry<k, v>> set = new HashSet<>();
        Iterator<k> ki = keys.iterator();
        Iterator<v> vi = values.iterator();

        while (ki.hasNext()) {
            set.add(new Entry<k, v>() {
                @Override
                public k getKey() {
                    return null;
                }

                @Override
                public v getValue() {
                    return null;
                }

                @Override
                public v setValue(v value) {
                    return null;
                }
            });
        }

        return set;
    }

    public v put(k key, v value) {
        v oldValue = get(key);

        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else {
            values.set(keys.indexOf(key), value);
        }

        return oldValue;
    }

    public v get(Object key) { // change the "Object" to "k" : both methods have same erasure, yet neither overrides the other
        if (!keys.contains(key)) {
            return null;
        }
        return values.get(keys.indexOf(key));
    }

    public static void main(String[] args) {
        SlowMap<String, String> m = new SlowMap<>();
        m.putAll(Countries.capitals(5));
        System.out.println(m);
        System.out.println(m.entrySet());
    }
}
