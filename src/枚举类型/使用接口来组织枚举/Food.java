package 枚举类型.使用接口来组织枚举;

/**
 * Created by ycz on 2017/12/14.
 */
public interface Food {
    enum Coffee implements Food {
        BLACK_COFFEE, LATTE, TEA
    }

    enum Dessert implements Food {
        TIRAMISU, GELATO, FRUIT
    }
}
