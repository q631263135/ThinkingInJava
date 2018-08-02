package 枚举类型.基本enum特性;

/**
 * Created by Administrator on 2017/10/26 0026.
 */
public enum OzWitch {
    WEST("西方"),
    NORTH("北方"),
    EAST("东方"),
    SOUTH("南方");

    private String desc;

    private OzWitch(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values()) {
            System.out.println(witch.getDesc());
        }
    }
}
