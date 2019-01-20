package 练习;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by ycz on 2019/1/20.
 */
public class ListCopyTest {
    public static void main(String[] args) {
        List source = new ArrayList();

        source.add(new Student(1));
        source.add(new Student(2));

        List dest = new ArrayList();
        dest.add(new Student(-1));
        dest.add(new Student(-2));
        Collections.fill(dest, new Student(0));

        Collections.copy(dest, source);

        Student o = (Student)dest.get(0);
        o.setId(11);


        System.out.println(source.toString());
    }
}

class Student {
    private int id;
    private String name;
    private int age;
    private int grade;

    public Student(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }
}