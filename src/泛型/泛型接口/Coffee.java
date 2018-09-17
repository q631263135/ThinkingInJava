package 泛型.泛型接口;

/**
 * Created by ycz on 2018/8/14.
 */
public class Coffee {
    private static long counter = 0;

    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getName() + " " + id;
    }

    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        System.out.println(coffee.toString());
    }
}
