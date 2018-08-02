package 注解.生成外部文件;

/**
 * Created by ycz on 2017/11/28 0028.
 */
@DBTable(name = "MEMBER")
// 类的注解@DBTable给定了值MEMBER，它将来会作为表的名字
public class Member {

    @SQLInteger(name = "mid", constraints = @Constraints(primaryKey = true, allowNull = false))
    Integer id;
    // Bean的属性，被注解为@SQLString，其元素值为30，该值设置SQL列的大小，并使用了嵌入的@Constraints注解的默认值
    @SQLString(30)
    String firstName;

    @SQLString(50)
    String lastName;

    @SQLInteger
    Integer age;

    @SQLString(value = 30, constraints = @Constraints(primaryKey = true))
    String handle;

    @TableColumn(ColumnType.STRING)
    String mycol;
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }
}
