package 内部类.链接到外部类;


import javax.naming.InitialContext;

public class Sequence {
    private String name;

    private Object[] items;
    private int next = 0;
    public  Sequence(int size) {
        items = new Object[size];
    }
    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }

    private class SequenceSelector implements Selector {

        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }

        public void showName() {
            System.out.println(name);
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence s = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            s.add(Integer.toString(i));
        }

        Selector selector = s.selector();
        while (!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }


        // selector = (SequenceSelector)selector; // Variable 'selector' is assigned to itself
        // ((SequenceSelector) selector).showName();
        SequenceSelector selector2 = (SequenceSelector)selector;
        selector2.showName();
    }
}
