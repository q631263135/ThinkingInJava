package 泛型.简单泛型.一个堆栈类;

/**
 * Created by ycz on 2018/8/13.
 */
public class LinkedStack<T> {
    private static class Node<U> {
        U item;

        Node<U> next;

        public Node() {
            item = null;
            next = null;
        }

        public Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        public boolean end() {
            return item == null && next == null;
        }
    }

    private Node<T> top = new Node<T>();

    public void push(T item) {
        top = new Node<T>(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> ls = new LinkedStack<String>();
        for (String s : "haha hehe xixi".split(" ")) {
            ls.push(s);
        }

        String s;
        while ((s = ls.pop()) != null) {
            System.out.println(s);
        }
    }
}
