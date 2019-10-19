package 并发.线程之间的协作.生产者和消费者.chap3;

/**
 * Created by ycz on 2019/9/27.
 */
public class MoneyDesire implements Runnable {

    private Person person;

    public MoneyDesire(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        person.run();
    }
}
