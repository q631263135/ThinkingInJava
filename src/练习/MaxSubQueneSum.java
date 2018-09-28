package 练习;

import java.util.Arrays;

/**
 * Created by ycz on 2018/2/1.
 *
 * Completed at 2018-2-2 02:01:41
 * <p>took a time...about 2 hours.</p>
 */
public class MaxSubQueneSum {
    private static int[] queneArr = {4, -3, 5, 2, 10, 2, 6, -2};
//    private static int[] queneArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {

        MaxSubQuene maxSubQuene = binaryDivide(queneArr, 0);

        System.out.println(maxSubQuene.startPosition + " " + maxSubQuene.endPosition + " " + maxSubQuene.maxSum);
    }


    private static MaxSubQuene binaryDivide(int a[], int position) {

        MaxSubQuene quene = new MaxSubQuene(queneArr);

        if (a.length == 1) {
            quene.maxSum = a[0];
            quene.startPosition = position;
            quene.endPosition = position;
        } else {
            int temp1[] = Arrays.copyOfRange(a, 0, a.length / 2);
            int temp2[] = Arrays.copyOfRange(a, a.length / 2, a.length);

            MaxSubQuene q1 = binaryDivide(temp1, position);
            MaxSubQuene q2 = binaryDivide(temp2, position + a.length / 2);
            quene.memory(q1, q2);
        }

        return quene;


    }
}

class MaxSubQuene {
    public int startPosition;

    public int endPosition;

    public int maxSum = 0;

    private int [] quene;

    public MaxSubQuene(int[] queneArr) {
        this.quene = queneArr;
    }

    @Override
    public String toString() {
        return "{" +
                "startPosition=" + startPosition +
                ", endPosition=" + endPosition +
                ", maxSum=" + maxSum +
                '}';
    }

    public void memory(MaxSubQuene q1, MaxSubQuene q2) {
        int temp = 0;
        for (int i = q1.startPosition; i <= q2.endPosition; i++) {
            temp += this.quene[i];
        }

        if (this.maxSum < temp && q1.maxSum < temp && q2.maxSum < temp) {
            this.maxSum = temp;
            this.startPosition = q1.startPosition;
            this.endPosition = q2.endPosition;
        } else if (this.maxSum < q1.maxSum) {
            this.maxSum = q1.maxSum;
            this.startPosition = q1.startPosition;
            this.endPosition = q1.endPosition;
        } if (this.maxSum < q2.maxSum) {
            this.maxSum = q2.maxSum;
            this.startPosition = q2.startPosition;
            this.endPosition = q2.endPosition;
        }


    }
}
