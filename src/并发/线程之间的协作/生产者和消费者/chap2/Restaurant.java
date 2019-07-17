package 并发.线程之间的协作.生产者和消费者.chap2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ycz on 2019/7/17.
 *
 * 这个程序是说有一个饭店。饭店里面呢有一个厨师，还有一个还有一个服饰生。
 * 在服饰生类和，厨师那里面，然后都有一个饭店标识，它是属于哪个饭店的？
 * 然后服务生和厨师就马不停蹄的要run了。
 * 那每次转的时候呢，他都会去，嗯。看一下访问肉这个资源。
 * 那就是我们需要对肉去进行一个枷锁。
 * 然后呢？服务生呢？嗯。他去没有肉的话他会去等待，然后有肉的话呢，他就会拿到肉，
 * 然后同时呢通知出厨师呢啊，继续去。嗯。这肉吃哈。就这样。
 */
public class Restaurant {
    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);

    public Restaurant() {
        exec.execute(chef);
        exec.execute(waitPerson);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}
