package 并发.性能调优.免锁容器.chap2;

import 容器.选择接口的不同实现.CountingIntegerList;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <br/>
 *
 * @author yangchaozheng
 * @date 2019/8/28 19:23
 */
public class CopyOnWriteArrayListTest extends ListTest {
    public CopyOnWriteArrayListTest(int nReaders, int nWriters) {
        super("CopyOnWriteArrayList", nReaders, nWriters);
    }

    @Override
    List<Integer> containerInitializer() {
        return new CopyOnWriteArrayList<>(new CountingIntegerList(containerSize));
    }
}
