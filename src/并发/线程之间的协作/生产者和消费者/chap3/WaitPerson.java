package 并发.线程之间的协作.生产者和消费者.chap3;

import java.util.concurrent.TimeUnit;

/**
 * Created by ycz on 2019/7/17.
 */
public class WaitPerson extends Person {
    private Restaurant restaurant;

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    // 为了钱而奔波
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) { // 服务生锁，一会通知这个服务生锁
                    while (restaurant.meal == null) {
                        wait();
                        System.out.println("Waitperson got notify");

                        // 碰到了一个慢悠悠的服务生
                        // 注释掉改行，有可能看不到 Chef 中的打印：Chef got notify
                        TimeUnit.SECONDS.sleep(1);
                    }
                }

                System.out.println("Waitperson got " + restaurant.meal);

                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();
                }
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
