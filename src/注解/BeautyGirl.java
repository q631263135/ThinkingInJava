package 注解;

import java.lang.annotation.Annotation;

/**
 * Created by Administrator on 2017/10/30 0030.
 */
@Description(name = "郑文静")
public class BeautyGirl {
    public static void main(String[] args) throws ClassNotFoundException {
        Class beautyGirl = Class.forName("注解.BeautyGirl");
        if (beautyGirl.isAnnotationPresent(Description.class)) {
            Annotation[] annotations = beautyGirl.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Description) {
                    Description desc = (Description)annotation;
                    System.out.println("我叫" + desc.name() + "，我今年" + desc.age() + "岁");
                }
            }
        }
    }
}
