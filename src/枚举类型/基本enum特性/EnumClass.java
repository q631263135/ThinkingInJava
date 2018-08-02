package 枚举类型.基本enum特性;

/**
 * Created by Administrator on 2017/10/26 0026.
 */
enum Shrubbery {
    GROUND,
    CRAWLING,
    HANGING
}

public class EnumClass {
    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            System.out.println(s.ordinal()); // 0 1 2
            System.out.println(s.compareTo(Shrubbery.CRAWLING)); // -1 0 1
            System.out.println(s.equals(Shrubbery.CRAWLING)); // false true false
            System.out.println(s.name()); // GROUND CRAWLING HANGING
            System.out.println(s.getDeclaringClass()); // class 枚举类型.基本enum特性.Shrubbery
        }

        for (String s : "GROUND CRAWLING HANGING".split(" ")) {
            Shrubbery shrubbery = Enum.valueOf(Shrubbery.class, s);
            System.out.println(shrubbery); // GROUND CRAWLING HANGING
        }
    }
}
