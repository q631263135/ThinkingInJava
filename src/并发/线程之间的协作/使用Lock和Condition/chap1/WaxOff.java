package 并发.线程之间的协作.使用Lock和Condition.chap1;

import java.util.concurrent.TimeUnit;

public class WaxOff implements Runnable {
    private Car car;

    public WaxOff(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                System.out.println("Wax Off! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
                car.waitForWaxing();
            } catch (InterruptedException e) {
                System.out.println("Exiting via interrupt");
            }
        }
        System.out.println("Ending Wax Off task");
    }
}
