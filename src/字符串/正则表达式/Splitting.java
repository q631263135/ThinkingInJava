package 字符串.正则表达式;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/12/10 0010.
 */
public class Splitting {
    static String knights = "Then, when you have found the shrubbery, you must cut down the mightiest tree in the forest... with... a herring";


    static void split(String regex) {
        System.out.println(Arrays.toString(knights.split(regex)));
    }

    public static void main(String[] args) {
        split(" ");
        split("\\W+");
        split("n\\W+");
    }
}

