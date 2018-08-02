package 练习;

import 内部类.在方法和作用域内的内部类.练习.Main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by ycz on 2017/12/19 0019.
 */
public class TransMap2Object {
    public static <T> T trans(Class<T> clazz, Map<String, String> map) throws IllegalAccessException, InstantiationException, InvocationTargetException {

        T t = clazz.newInstance();

        Set set = map.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                if (method.getName().startsWith("set")) {
                    if (method.getName().substring(3).toUpperCase().equals(next)) {
                        method.invoke(t, map.get(next));
                    }
                }
            }
        }
        return t;
    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Map m = new HashMap();
        m.put("NAME", "YCZ");
        m.put("L_VALUE", 1000l);
        Goods goods = trans(Goods.class, m);
        System.out.println(goods);
    }
}
