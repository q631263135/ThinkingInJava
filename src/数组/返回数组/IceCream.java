package 数组.返回数组;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by ycz on 2018/8/3.
 */
public class IceCream {
    private static Random rand = new Random(47);

    static final String[] FLAVORS = {
            "Chocolate", "Strawberry", "Vanilla Fudge", "Mint Chip", "Mocha Alomond Fudge",
            "Rum", "Praline", "Mud"
    };

    public static String[] flavorSet(int n) {
        if (n > FLAVORS.length) {
            throw new IllegalArgumentException("Set too big");
        }

        String[] results = new String[n];

        boolean[] picked = new boolean[FLAVORS.length];

        for (int i = 0; i < n; i++) {
            int t;
            do {
                t = rand.nextInt(FLAVORS.length);
            } while (picked[t]);

            results[i] = FLAVORS[t];

        }
        return results;
    }

    public static void main(String[] args) {
        System.out.println(flavorSet(5));
        System.out.println(Arrays.toString(flavorSet(5)));

        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(flavorSet(3)));
        }
    }
}
