package 枚举类型.values神秘之处;

import 枚举类型.OSExecute;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by ycz on 2017/11/16 0016.
 */
enum Explore {
    HERE, THERE
}

public class Reflection {
    public static Set<String> analyze(Class<?> enumClass) {
        System.out.println("----- Analyze " + enumClass + " -----");
        System.out.println("Interfaces: ");
        for (Type t : enumClass.getGenericInterfaces()) {
            System.out.println(t);
        }

        System.out.println("Base: " + enumClass.getSuperclass());

        System.out.println("Methods: ");
        Set<String> methods = new TreeSet<String>();
        for (Method m : enumClass.getMethods()) { // enumClass.getDeclaredMethods()
            methods.add(m.getName());
        }
        System.out.println(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set exploreMethods = analyze(Explore.class);
        Set enumMethods = analyze(Enum.class);

        System.out.println("----- Explore.containsAll(Enum)?  -----");
        System.out.println(exploreMethods.containsAll(enumMethods));

//        OSExecute.command("javap Explore");
    }
}
/*
----- Analyze class 枚举类型.values神秘之处.Explore -----
Interfaces:
Base: class java.lang.Enum
Methods:
[valueOf, values]
----- Analyze class java.lang.Enum -----
Interfaces:
java.lang.Comparable<E>
interface java.io.Serializable
Base: class java.lang.Object
Methods:
[clone, compareTo, equals, finalize, getDeclaringClass, hashCode, name, ordinal, readObject, readObjectNoData, toString, valueOf]
*/
