package 并发.基本的线程机制.创建有响应的用户界面;

import java.io.IOException;

/**
 * Created by ycz on 2019/4/23.
 */
public class ResponsiveUI extends Thread {
    private static volatile double d = 1;

    public ResponsiveUI() {
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        while (true) {
            d = d + (Math.PI + Math.E) / d;
        }
    }

    public static void main(String[] args) throws IOException {
        new ResponsiveUI();

        int read = System.in.read();

        System.out.println(d);
    }
}
