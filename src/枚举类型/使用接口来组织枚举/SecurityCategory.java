package 枚举类型.使用接口来组织枚举;

import 枚举类型.随机选取Enum.Enums;

import java.util.Random;

/**
 * Created by ycz on 2017/12/28.
 */
public enum SecurityCategory {
    STOCK(Security.Stock.class), BOND(Security.Bond.class);


    private Security[] security;

    SecurityCategory(Class<? extends Security> clazz) {
        security = clazz.getEnumConstants();
    }

    interface Security {
        enum Stock implements Security { SHORT, LONG, MARGIN }

        enum Bond implements Security { MUNICIPAL, JUNK }
    }

    public Security randomSelection() {
        return Enums.random(security);
    }

    public static void main(String[] args) {
        SecurityCategory sc = Enums.random(SecurityCategory.class);
        for (int i = 0; i < 10; i++) {
            System.out.println(sc + ": " + sc.randomSelection());
        }
        // Enums 中的 Random 是静态变量，nextInt每次都会不一样了
    }

}
