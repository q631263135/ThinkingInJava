package 容器.填充容器;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ycz on 2018/8/28.
 */
class StringAddress {
    private String s;

    public StringAddress(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return super.toString() + " " + s;
    }
}

public class FillingLists {

    public static void main(String[] args) {

        List<StringAddress> copies = Collections.nCopies(4, new StringAddress("hello"));
        List<StringAddress> list = new ArrayList<StringAddress>(copies);
        System.out.println(list);

        Collections.fill(list, new StringAddress("world"));
        System.out.println(list);
    }
}
