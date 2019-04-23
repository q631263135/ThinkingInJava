package 并发.基本的线程机制.创建有响应的用户界面;

import java.io.IOException;

/**
 * Created by ycz on 2019/4/23.
 */
public class SystemInTest {
    public static void main(String[] args) {
        for (int j = 1; j < 6; j++) {
            System.out.println("let's do, it's your " + j + " times");
            try {
                int read = System.in.read(); // 当键盘输入字符后，每次读取一个出来

                if (read == 13) {
                    System.out.println("You enter the '回车'");
                    continue;
                }

                char c = (char) read;
                System.out.println("You enter the '" + c + "'");

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
