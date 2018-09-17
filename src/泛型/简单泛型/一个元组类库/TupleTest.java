package 泛型.简单泛型.一个元组类库;

/**
 * Created by ycz on 2018/8/13.
 */

class Amphibian {}

class Vehicle {}

public class TupleTest {
    static TwoTuple<String, Integer> f() {
        return new TwoTuple<String, Integer>("hi", 22);
    }

    static ThreeTuple<Vehicle, Amphibian, String> g() {
        return new ThreeTuple<>(new Vehicle(), new Amphibian(), "hi");
    }
}
