package 练习;

/**
 * Created by ycz on 2017/12/19 0019.
 */
public class Goods {
    private String name;

    private Double price;

    private Long l_value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getL_value() {
        return l_value;
    }

    public void setL_value(Long l_value) {
        this.l_value = l_value;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", l_value=" + l_value +
                '}';
    }
}
