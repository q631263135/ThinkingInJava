package 并发.线程之间的协作.生产者和消费者.chap2;

import java.util.concurrent.TimeUnit;

/**
 * Created by ycz on 2019/7/17.
 */
public class WaitPerson implements Runnable {
    private Restaurant restaurant;

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) { // 服务生锁，一会通知这个服务生锁
                    while (restaurant.meal == null) {
                        wait();
                    }
                }

                System.out.println("Waitperson got " + restaurant.meal);

                System.out.println("Waitperion's lazy ...");

                TimeUnit.SECONDS.sleep(5);

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
