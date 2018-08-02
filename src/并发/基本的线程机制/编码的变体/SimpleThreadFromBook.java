package 并发.基本的线程机制.编码的变体;

/**
 * Created by ycz on 2017/12/20.
 * 下面这个实例是书本上的
 */
public class SimpleThreadFromBook extends Thread {
    private int countDown = 5;

    private static int threadCount = 0;

    public SimpleThreadFromBook() {
        super(Integer.toString(++threadCount)); // Integer.toString，学到了
        start(); // 这里怎么start啊？构造函数还没把实例构造出来呢，这个谁来调用啊？细想下
        // 如果不是t.start()而仅仅是其他函数，如toString方法，依然是上面的这个疑问。
        // 我想构造函数new的时候实例就出来了，然后再执行里面的方法，this这个指针指向的就是那个实例
    }

    @Override
    public String toString() {
        return "#" + getName() + "(" + countDown + ")";
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this);
            if (--countDown == 0)
                return;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SimpleThreadFromBook();
        }
    }
}
