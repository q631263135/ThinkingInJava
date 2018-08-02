package 练习;

import 注解.Description;

import java.lang.annotation.Annotation;

/**
 * Created by ycz on 2017/12/4 0004.
 */
@Sex(SexVal.MALE)
public class Man {
    public static void main(String[] args) {
        Class<Man> man = Man.class;
        System.out.println(man.isAnnotationPresent(Sex.class));
        System.out.println(man.isAnnotationPresent(Description.class));
        Annotation[] annotations = man.getAnnotations();
        for (Annotation anno : annotations) {
            System.out.println(anno.toString());
            if (anno instanceof Sex) {
                Sex sex = (Sex)anno;
                System.out.println(sex.age());
                System.out.println(sex.value());
            }
        }
    }
}
/*
output:
Exception in thread "main" java.lang.IllegalAccessError: tried to access class 练习.SexVal from class com.sun.proxy.$Proxy1
at com.sun.proxy.$Proxy1.value(Unknown Source)
at 练习.Man.main(Man.java:21)
at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
at java.lang.reflect.Method.invoke(Method.java:606)
at com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)
true
false
@练习.Sex(value=MALE)*/
