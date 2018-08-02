package 枚举类型.向enum中添加方法;


/**
 * Created by ycz on 2017/11/16 0016.
 */
public enum SpaceShip {
    CHANGE, TIANGONG, FEITIAN;

    @Override
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }

    public static void main(String[] args) {
        SpaceShip[] values = SpaceShip.values();
        for (SpaceShip ss : SpaceShip.values()) {
            System.out.println(ss.toString());
        }
    }
}
