package 并发.基本的线程机制.Thread类;

import 并发.基本的线程机制.定义任务.LiftOff;

/**
 * Created by Administrator on 2017/11/10 0010.
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
    }
}
