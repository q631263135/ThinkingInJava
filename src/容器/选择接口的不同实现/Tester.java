package 容器.选择接口的不同实现;

import java.util.List;

/**
 * Created by ycz on 2018/11/15.
 */
public class Tester<C> {
    public static int fieldWidth = 8;

    private static String stringField() {
        return "%" + fieldWidth + "s";
    }

    private static String numberField() {
        return "%" + fieldWidth + "d";
    }

    public static TestParam[] defaultParams = TestParam.array(10, 5000, 100, 5000, 1000, 5000, 10000, 5000);
    protected C container;
    protected C initialize(int size) {
        return container;
    }

    private String headline = "";
    private List<Test<C>> tests;

    private static int sizeWidth = 5;
    private static String sizefield = "%" + sizeWidth + "s";
    private TestParam[] paramList = defaultParams;

    public Tester(C container, List<Test<C>> tests) {
        this.container = container;
        this.tests = tests;
    }

    public Tester(C container, List<Test<C>> tests, TestParam[] paramList) {
        this.container = container;
        this.tests = tests;
        this.paramList = paramList;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public static <C> void run(C cntnr, List<Test<C>> tests, TestParam[] paramList) {
        new Tester<C>(cntnr, tests, paramList).timedTest();
    }

    public void timedTest() {
        displayHeader();

        for (TestParam param : paramList) {
            System.out.format(sizefield, param.size);

            for (Test<C> test : tests) {
                C container = initialize(param.size);
                long start = System.nanoTime();

                int reps = test.test(container, param);
                long duration = System.nanoTime() - start;
                long timePerRep = duration / reps;
                System.out.format(numberField(), timePerRep);
            }
            System.out.println();
        }
    }

    private void displayHeader() {
        int width = fieldWidth * tests.size() + sizeWidth;
        int dashLength = width - headline.length() - 1;
        StringBuilder head = new StringBuilder(width);
        for (int i = 0; i < dashLength / 2; i++) {
            head.append('-');
        }
        head.append(' ');
        head.append(headline);
        head.append(' ');
        for (int i = 0; i < dashLength / 2; i++) {
            head.append('-');
        }
        System.out.println(head);
        System.out.format(sizefield, "size");
        for (Test test : tests) {
            System.out.format(stringField(), test.name);
        }
        System.out.println();
    }

}
