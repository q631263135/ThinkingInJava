package 泛型.擦除;

/**
 * Created by ycz on 2018/8/24.
 */
public class ErasureAndInheritance {
    public static void main(String[] args) {
        Derived2 derived2 = new Derived2();
        Object o = derived2.get();
        // Unchecked call to 'set(T)' as a member of raw type '泛型.擦除.GenericBase'
        derived2.set(o);

//        Derived2 derived22 = new Derived2<String>(); // Type '泛型.擦除.Derived2' does not have type parameters

        Derived1 derived1 = new Derived1<Integer>();
        Integer integer = (Integer) derived1.get();
        // Unchecked call to 'set(T)' as a member of raw type '泛型.擦除.GenericBase'
        derived1.set(integer);

        Derived1<Integer> derived11 = new Derived1();
        Integer integer2 = (Integer) derived1.get();
        // Unchecked call to 'set(T)' as a member of raw type '泛型.擦除.GenericBase'
        derived1.set(integer);
    }
}

class GenericBase<T> {
    private T el;

    public void set(T arg) {
        this.el = arg;
    }

    public T get() {
        return el;
    }

}

class Derived1<T> extends GenericBase<T> {}

// 因为擦除的存在，下面代码也是兼容的
class Derived2 extends GenericBase {}

