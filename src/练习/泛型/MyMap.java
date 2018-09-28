package 练习.泛型;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Administrator on 2018/9/21 0021.
 */
public class MyMap extends LinkedHashMap {

    public static void main(String[] args) {
        List<MyMap> myMaps = null;

        List<? extends LinkedHashMap> receive = new ArrayList<>();

        for (MyMap mymap : myMaps) {
//            receive.add(mymap);
            // 无法通过方法调用转换将实际参数练习.泛型.MyMap转换为capture#1,
            // 共 ? extends java.util.LinkedHashMap
        }

        test(myMaps);

        List<HashMap> hlist = new ArrayList<>();

//        test(hlist);
    }

    public static <T extends LinkedHashMap> void test(List<T> l) {

    }
}


