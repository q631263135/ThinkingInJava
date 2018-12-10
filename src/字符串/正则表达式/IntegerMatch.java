package 字符串.正则表达式;

/**
 * Created by Administrator on 2018/12/10 0010.
 */
public class IntegerMatch {

    public static void main(String[] args) {
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("1234".matches("-?\\d+"));
        System.out.println("+1234".matches("-?\\d+"));
        System.out.println("+1234".matches("(-|\\+)\\d+"));
        System.out.println("\\1234".matches("(\\\\|\\+)\\d+"));
    }
}
