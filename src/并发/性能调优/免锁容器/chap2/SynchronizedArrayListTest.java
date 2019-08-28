package 并发.性能调优.免锁容器.chap2;

import 容器.选择接口的不同实现.CountingIntegerList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <br/>
 *
 * @author yangchaozheng
 * @date 2019/8/28 19:23
 */
public class SynchronizedArrayListTest extends ListTest {
    public SynchronizedArrayListTest(int nReaders, int nWriters) {
        super("SynchronizedArrayList", nReaders, nWriters);
    }

    @Override
    List<Integer> containerInitializer() {
        return Collections.synchronizedList(new ArrayList<>(new CountingIntegerList(containerSize)));
    }
}
