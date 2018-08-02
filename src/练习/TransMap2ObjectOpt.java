package 练习;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ycz on 2017/12/19 0019.
 */
public class TransMap2ObjectOpt {
    public static <T> T transMap2Object(Map map, Class<T> clazz) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        T t = clazz.newInstance();

        Method[] declaredMethods = clazz.getDeclaredMethods();
        String key = null;
        for (Method m : declaredMethods) {

            key = m.getName().substring(3).toUpperCase();
            if (m.getName().startsWith("set") && map.containsKey(key)) {

                Class<?>[] parameterTypes = m.getParameterTypes();
                System.out.println(parameterTypes[0]); // class java.lang.Long
                if (parameterTypes[0].toString().contains("Long")) {
                    m.invoke(t, Long.parseLong(map.get(key).toString()) + 1l);
                } else {
                    m.invoke(t, map.get(key));
                }
            }
        }


        return t;
    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Map m = new HashMap();
        m.put("NAME", "YCZ");
        m.put("L_VALUE", 1000L);
        Goods goods = transMap2Object(m, Goods.class);
        System.out.println(goods);
    }
}
