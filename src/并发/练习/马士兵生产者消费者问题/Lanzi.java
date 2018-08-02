package 并发.练习.马士兵生产者消费者问题;

/**
 * Created by ycz on 2018/1/23.
 */

/**
 * 篮子
 */
public class Lanzi {

    private int numOfWotou = 0;

    private Wotou[] wotous;

    public void push(Wotou wotou) {
        wotous[numOfWotou++] = wotou;
    }

    public Wotou pop() {
        return wotous[numOfWotou--];
    }

}
