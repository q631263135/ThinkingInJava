package 枚举类型.使用接口来组织枚举;
import static 枚举类型.使用接口来组织枚举.Food.*;
/**
 * Created by ycz on 2017/12/14.
 */
public class TypeOfFood {
    public static void main(String[] args) {
        Food food = Coffee.BLACK_COFFEE;
        food = Dessert.FRUIT;
    }
}
