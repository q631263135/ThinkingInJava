package 数组.数组与泛型;

/**
 * Created by ycz on 2018/8/6.
 */
class Banana {

}

public class Peel<T> {
    public T[] f(T[] args) {
        return args;
    }

    public static void main(String[] args) {
        Peel<Banana> peel = new Peel<Banana>();

        peel.f(new Banana[1]);

//        Peel<Banana>[] peels = new Peel<Banana>[1];
    }
}

