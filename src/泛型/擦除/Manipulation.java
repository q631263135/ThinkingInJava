package 泛型.擦除;

/**
 * Created by ycz on 2018/8/22.
 */
class HasF {
    public void f() {};
}

class Manipulator<T> {
    private T obj;

    public Manipulator(T obj) {
        this.obj = obj;
    }

    public void manipulate() {
        // obj.f();
        System.out.println(obj);
    }
}

class Manipulator2<T extends HasF> {
    private T obj;

    public Manipulator2(T obj) {
        this.obj = obj;
    }

    public void manipulate() {
        obj.f();
    }
}

class ReturnGenericType<T extends HasF> {
    private T obj;

    public ReturnGenericType(T obj) {
        this.obj = obj;
    }

    public T get() {
        return obj;
    }
}

public class Manipulation {
    public static void main(String[] args) {
        Manipulator<HasF> manipulator = new Manipulator<HasF>(new HasF());
        manipulator.manipulate();

        Manipulator2<HasF> manipulator2 = new Manipulator2<HasF>(new HasF());
        manipulator.manipulate();
    }
}
