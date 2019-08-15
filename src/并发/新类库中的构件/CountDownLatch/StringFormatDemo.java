package 并发.新类库中的构件.CountDownLatch;

/**
 * Created by ycz on 2019/8/15.
 */
public class StringFormatDemo {
    public static void main(String[] args) {
        // %d	整数	对整数进行格式化输出
        System.out.println(String.format("hello%d", 1) + "hi");
        System.out.println(String.format("hello%3d", 1) + "hi");
        System.out.println(String.format("hello%-3d", 1111) + "hi");
        System.out.println(String.format("hello%3d", 1111) + "hi");
        System.out.println(String.format("%-3d", 1) + "hi");
        System.out.println(String.format("%-3d", 1111) + "hi");
        System.out.println(String.format("hello%-6d", 1) + "hi");
        System.out.println(String.format("hello%1$-3d", 1) + "hi");
        System.out.println(String.format("hello%1$-3d", 1111) + "hi");
    }
}
