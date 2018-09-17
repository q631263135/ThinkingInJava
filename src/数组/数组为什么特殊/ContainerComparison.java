package 数组.数组为什么特殊;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ycz on 2018/8/3.
 */

class BerylliumSphere {
    private static long counter;

    private final long id = counter++;

    @Override
    public String toString() {
        return "BerylliumSphere{" +
                "id=" + id +
                '}';
    }
}

public class ContainerComparison {
    public static void main(String[] args) {
        BerylliumSphere[] spheres = new BerylliumSphere[10];

        for (int i = 0; i < 5; i++) {
            spheres[i] = new BerylliumSphere();
        }

        System.out.println(Arrays.toString(spheres));
        System.out.println(spheres[4]);


        int[] integers = {0, 1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(integers));

        List<Integer> intList = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5));
        intList.add(97);
        System.out.println(intList);


    }
}
