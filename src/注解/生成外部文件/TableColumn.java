package 注解.生成外部文件;

/**
 * Created by ycz on 2017/11/28 0028.
 */
enum ColumnType {
    STRING, INTEGER, FLOAT, DOUBLE

}

public @interface TableColumn {
    ColumnType value() default ColumnType.STRING;
}
