package 容器.散列和散列码;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Administrator on 2018/9/18 0018.
 */

class Groundhog {
    protected int number;

    public Groundhog(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Groundhog #" + number;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Groundhog groundhog = (Groundhog) o;

        return number == groundhog.number;
    }

    @Override
    public int hashCode() {
        return number;
    }*/
}

class Prediction {
    private static Random rand = new Random(47);

    private boolean shadow = rand.nextBoolean();

    @Override
    public String toString() {

        if (shadow) {
            return "Six more weeks of Winter!";
        }
        else {
            return "Early Spring";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Prediction that = (Prediction) o;

        if (shadow != that.shadow) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return (shadow ? 1 : 0);
    }
}

public class SpringDetector {

    public static <T extends Groundhog> void detectingSpring(Class<T> type) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<T> constructor = type.getConstructor(int.class);
        Map<Groundhog, Prediction> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(constructor.newInstance(i), new Prediction());
        }

        System.out.println("map= " + map);

        Groundhog gh = constructor.newInstance(3);
        System.out.println("Looking up prediction for " + gh);

        if (map.containsKey(gh)) {
            System.out.println(map.get(gh));
        } else {
            System.out.println("Key not found: " + gh);
        }

    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        detectingSpring(Groundhog.class);

        // output:
        // Looking up prediction for Groundhog #3
        // Key not found: Groundhog #3

        // Tips: must Override Groundhog equals & hashCode
    }
}
