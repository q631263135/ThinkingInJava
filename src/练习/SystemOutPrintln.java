package 练习;

/**
 * Created by ycz on 2018/10/23.
 */
public class SystemOutPrintln {

    private static int line = 1;

    public static void println(Object o) {
        System.out.println("打印第" + line++ + "个输出： " + o.toString());
    }

    public static void main(String[] args) {
        SystemOutPrintln.println("abc");
    }
}
