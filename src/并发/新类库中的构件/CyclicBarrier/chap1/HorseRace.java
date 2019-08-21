package 并发.新类库中的构件.CyclicBarrier.chap1;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by ycz on 2019/8/21.
 */
public class HorseRace implements Runnable {
    private volatile CountDownLatch countDownLatch4Race;
    private volatile CountDownLatch countDownLatch4Horse;
    static final int FINISH_LINE = 75;
    private static List<Horse> horses = new ArrayList<>();


    public HorseRace() {
        countDownLatch4Race = new CountDownLatch(3);
        countDownLatch4Horse = new CountDownLatch(1);

        for (int i = 0; i < 3; i++) {
            Horse horse = new Horse(countDownLatch4Race, countDownLatch4Horse);
            horses.add(horse);
        }
    }

    @Override
    public void run() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < FINISH_LINE; i++) {
            sb.append("=");
        }
        System.out.println(sb);

        while (!Thread.interrupted()) {

            try {
                System.out.println("门闩在等countDownLatch4Race" + countDownLatch4Race.getCount());
                countDownLatch4Race.await();
                System.out.println("我来看看赛马道了");
                countDownLatch4Race = new CountDownLatch(3);
                System.out.println("我去打开门闩");
                countDownLatch4Horse.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (Horse horse : horses) {
                System.out.println(horse.tracks());
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new HorseRace());
        for (Horse horse : horses) {
            exec.execute(horse);
        }
    }
}
