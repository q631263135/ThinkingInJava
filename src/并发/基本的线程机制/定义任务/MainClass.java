package 并发.基本的线程机制.定义任务;

/**
 * Created by Administrator on 2017/11/10 0010.
 */
public class MainClass {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff(1));
        t.start();
//        LiftOff launch = new LiftOff();
//        launch.run();
    }
}
