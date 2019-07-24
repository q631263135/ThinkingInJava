package 并发.线程之间的协作.生产者消费者与队列.chap2;

/**
 * Created by ycz on 2019/7/24.
 */
public class Toast {
    public enum Status {DRY, BUTTERED, JAMMED}


    private Status status = Status.DRY;
    private final int id;

    public Toast(int id) {
        this.id = id;
    }

    public void butter() {
        status = Status.BUTTERED;
    }

    public void jam() {
        status = Status.JAMMED;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Toast{" +
                "status=" + status +
                ", id=" + id +
                '}';
    }
}
