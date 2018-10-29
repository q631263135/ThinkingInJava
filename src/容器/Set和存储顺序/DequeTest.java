package 容器.Set和存储顺序;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by ycz on 2018/10/29.
 */
public class DequeTest {
    static void fill(MyDeque<Integer> deque) {
        for (int i = 20; i < 27; i++) {
            deque.addFirst(i);
        }

        for (int i = 50; i < 55; i++) {
            deque.addLast(i);
        }
    }

    public static void main(String[] args) {
        MyDeque<Integer> myDeque = new MyDeque<>();

        // 测试从首端出队
        fill(myDeque);
        System.out.println(myDeque);

        while (myDeque.size() != 0) {
            System.out.print(myDeque.removeFirst() + " ");
        }

        System.out.println();

        // 测试从尾端出队
        fill(myDeque);
        System.out.println(myDeque);

        while (myDeque.size() != 0) {
            System.out.print(myDeque.removeLast() + " ");
        }
    }
}

class MyDeque<T> {
    private LinkedList<T> deque = new LinkedList<>();

    public void addFirst(T e) {
        deque.addFirst(e);
    }

    public void addLast(T e) {
        deque.addLast(e);
    }

    public T getFirst() {
        return deque.getFirst();
    }

    public T getLast() {
        return deque.getLast();
    }

    public T removeFirst() {
        return deque.removeFirst();
    }

    public T removeLast() {
        return deque.removeLast();
    }

    public int size() {
        return deque.size();
    }

    @Override
    public String toString() {
        return deque.toString();
    }
}