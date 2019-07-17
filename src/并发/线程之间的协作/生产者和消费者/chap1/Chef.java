package 并发.线程之间的协作.生产者和消费者.chap1;

import java.util.concurrent.TimeUnit;

/**
 * Created by ycz on 2019/7/17.
 */

public class Chef implements Runnable {
    private Restaurant restaurant;
    private int count;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null) {
                        wait();
                    }
                }

                if (++count == 10) {
                    restaurant.exec.shutdownNow();
                }
                System.out.println("Order up! ");
                synchronized (restaurant.waitPerson) {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
