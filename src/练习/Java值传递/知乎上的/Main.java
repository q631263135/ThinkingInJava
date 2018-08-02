package 练习.Java值传递.知乎上的;

/**
 * Created by ycz on 2018/1/9 0009.
 */
public class Main {
    public static void changeEmployee(Employee employee) {
        employee = new Employee();
        employee.age = 1000;
    }

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.age = 100;
        changeEmployee(employee);
        System.out.println(employee.age);

    }
}

/**
 * 猜测输出 100
 */

/**
 * java是值传递，在参数传递时，其实是new了一份的，new了的这个和“实际参数“指向同一内存区域
 *
 * 如果对new了的这一份重新赋值，那么必然改变它的引用区域了
 */