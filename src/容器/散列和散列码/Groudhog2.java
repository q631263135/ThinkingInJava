package 容器.散列和散列码;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by ycz on 2018/11/5.
 */
public class Groudhog2 extends Groundhog {
    public Groudhog2(int number) {
        super(number);
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
       return obj instanceof Groudhog2 && ((Groudhog2) obj).number == number;
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        SpringDetector.detectingSpring(Groudhog2.class);


    }
}
