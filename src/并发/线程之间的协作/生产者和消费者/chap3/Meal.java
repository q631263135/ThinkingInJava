package 并发.线程之间的协作.生产者和消费者.chap3;

/**
 * Created by ycz on 2019/7/17.
 */
public class Meal {
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "orderNum=" + orderNum +
                '}';
    }
}
