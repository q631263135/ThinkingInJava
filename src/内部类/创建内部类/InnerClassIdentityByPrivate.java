package 内部类.创建内部类;

public class InnerClassIdentityByPrivate {

    private String name;

    private class Inner implements InnerInterface {

        public void printOuterName() {
            System.out.println(InnerClassIdentityByPrivate.this.name);
            System.out.println(name);
        }
    }

    public InnerClassIdentityByPrivate(String name) {
        this.name = name;
    }

    public Inner getInner() {
        return new Inner();
    }
}
