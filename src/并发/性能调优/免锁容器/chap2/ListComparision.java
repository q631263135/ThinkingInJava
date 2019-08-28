package 并发.性能调优.免锁容器.chap2;

/**
 * <br/>
 *
 * @author yangchaozheng
 * @date 2019/8/28 19:27
 */
public class ListComparision {
    public static void main(String[] args) {
        Tester.initMain();
        new SynchronizedArrayListTest(9, 1);
        new CopyOnWriteArrayListTest(9, 1);
        Tester.exec.shutdown();
    }
}
