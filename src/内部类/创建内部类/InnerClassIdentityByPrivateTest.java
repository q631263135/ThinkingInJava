package 内部类.创建内部类;

import org.junit.Test;

public class InnerClassIdentityByPrivateTest {

    @Test
    public void testAccessInner() {
        InnerClassIdentityByPrivate innerClassIdentityByPrivate = new InnerClassIdentityByPrivate("yangchaozheng");
        // InnerClassIdentityByPrivate.Inner inner = innerClassIdentityByPrivate.getInner();
        // ↑↑↑'内部类.创建内部类.InnerClassIdentityByPrivate.Inner' has private access in '内部类.创建内部类.InnerClassIdentityByPrivate'
    }

    @Test
    public void testUseInnerWithInterface() {
        InnerClassIdentityByPrivate innerClassIdentityByPrivate = new InnerClassIdentityByPrivate("yangchaozheng");

        // 使用接口可以让本来是私有的东东，变成可以访问的了。
        // 或者说在语法上是不能直接访问私有的，但可以通过接口（貌似得以隐藏）的方式访问，目的在于不会看到真实的“自己”。
        InnerInterface inner = innerClassIdentityByPrivate.getInner();
        inner.printOuterName();
    }

}
