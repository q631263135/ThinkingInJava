package 泛型.擦除;

import java.util.*;

/**
 * Created by ycz on 2018/8/22.
 */
class Frob {
}

class Fnorkle {
}

class Quark<Q> {
}

class Particle<POSTION, MOMENTUM> {
}

public class LostInformation {
    public static void main(String[] args) {
        List<Frob> list = new ArrayList();
        List<Frob> list2 = new ArrayList<Frob>();
        Map<Frob, Fnorkle> map = new HashMap<Frob, Fnorkle>();
        Quark<Fnorkle> quark = new Quark<Fnorkle>();

        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));

        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));

        System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
    }
}
