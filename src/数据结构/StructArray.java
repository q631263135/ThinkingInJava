package 数据结构;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ycz on 2018/2/5.
 */
public class StructArray implements Comparator<StructArray>{

    private int polynomial;

    private int exponent;

    public StructArray(int polynomial, int exponent) {
        this.polynomial = polynomial;
        this.exponent = exponent;
    }

    @Override
    public int compare(StructArray o1, StructArray o2) {
        if (o1.exponent > o2.exponent) return 1;
        else if (o1.exponent > o2.exponent) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return "StructArray{" +
                "polynomial=" + polynomial +
                ", exponent=" + exponent +
                '}';
    }

    public static void main(String[] args) {

        List<StructArray> listA = new ArrayList<StructArray>();
        listA.add(new StructArray(9, 12));
        listA.add(new StructArray(15, 8));
        listA.add(new StructArray(3, 2));

        List<StructArray> listB = new ArrayList<StructArray>();
        listB.add(new StructArray(26, 19));
        listB.add(new StructArray(-4, 8));
        listB.add(new StructArray(-13, 6));
        listB.add(new StructArray(82, 0));

        List<StructArray> list = new ArrayList<StructArray>();

        int _j = 0;
        for (int i = 0; i < listA.size(); i++) {
            StructArray sa_i = listA.get(i);
            for (int j = _j; j < listB.size(); j++) {
                StructArray sa_j = listB.get(j);
                if (sa_i.exponent < sa_j.exponent) {
                    list.add(sa_j);
                    i--;
                    _j++;
                } else if (sa_i.exponent > sa_j.exponent) {
                    list.add(sa_i);
                } else {
                    list.add(new StructArray(sa_i.polynomial + sa_j.polynomial, sa_i.exponent));
                    _j++;
                }
                break;
            }
        }

        System.out.println(list);

    }



}
