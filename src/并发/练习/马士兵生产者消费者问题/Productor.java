package 并发.练习.马士兵生产者消费者问题;

/**
 * Created by ycz on 2018/1/23.
 */
public class Productor implements Runnable{

    private Lanzi lanzi;

    public Productor(Lanzi lanzi) {
        this.lanzi = lanzi;
    }

    @Override
    public void run() {
        Wotou wotou = new Wotou(1);
        lanzi.push(wotou);
    }
}
