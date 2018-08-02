package 练习;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ycz on 2017/12/4 0004.
 */
enum SexVal {
    MALE, FEMALE
}
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Sex {
    SexVal value();

    int age() default 18;
}
