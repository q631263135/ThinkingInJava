package 注解;

/**
 * Created by ycz on 2017/11/23 0023.
 */
enum Sex {
    MALE("男人"),
    FEMALE("女人");

    private String inf;

    public String getInf() {
        return inf;
    }

    public void setInf(String inf) {
        this.inf = inf;
    }

    Sex(String inf) {
        this.inf = inf;
    }
}

public class MethodTest {
    public static void main(String[] args) {
        Sex[] values = Sex.values();
        Sex value = values[0];

        System.out.println(value.getInf());

        System.out.println(values[0].toString());
    }
}
