package 容器.Set和存储顺序;

import java.util.PriorityQueue;

/**
 * Created by ycz on 2018/10/29.
 */
public class ToDoList extends PriorityQueue<ToDoList.ToDoItem> {


    static class ToDoItem implements Comparable<ToDoItem> {
        private char primary;
        private int secondary;
        private String item;

        public ToDoItem(String td, char pri, int sec) {
            item = td;
            primary = pri;
            secondary = sec;
        }

        @Override
        public int compareTo(ToDoItem o) {
            if (primary > o.primary) {
                return +1;
            }
            if (primary == o.primary) {
                if (secondary > o.secondary) {
                    return +1;
                }
                else if (secondary == o.secondary) {
                    return 0;
                }
            }
            return -1;
        }

        @Override
        public String toString() {
            return Character.toString(primary) + secondary + ": " + item;
        }
    }

    public void add(String td, char pri, int sec) {
        super.add(new ToDoItem(td, pri, sec));
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.add("学习java编程思想", 'C', 4);
        toDoList.add("学习设计模式", 'C', 5);
        toDoList.add("学习UML建模", 'D', 1);
        toDoList.add("学习线性代数", 'A', 3);
        toDoList.add("学习javaweb", 'B', 1);

        while (!toDoList.isEmpty()) {
            System.out.println(toDoList.remove());
        }
    }
}
