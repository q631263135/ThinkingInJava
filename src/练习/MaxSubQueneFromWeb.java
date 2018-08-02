package 练习;

/**
 * Created by ycz on 2018/2/2.
 */
public class MaxSubQueneFromWeb {

    public static void main(String[] args) {
        int[] queneArr = {4, -3, 5, 2, 10, 2, 6, -2};
        System.out.println(maxSubSum(queneArr));
    }

    public static int maxSubSum(int[] a) {
        return subSum3(a, 0, a.length - 1);
    }

    private static int subSum3(int[] a, int left, int right) {
        if (left == right)
            if (a[left] > 0)
                return a[left];
            else
                return 0;

        int center = (left + right) / 2;
        int maxLeftSum = subSum3(a, left, center);
        int maxRightSum = subSum3(a, center + 1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += a[i];
            if (leftBorderSum > maxLeftBorderSum)
                maxLeftBorderSum = leftBorderSum;
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            rightBorderSum += a[i];
            if (rightBorderSum > maxRightBorderSum)
                maxRightBorderSum = rightBorderSum;
        }

        return Math.max(Math.max(maxLeftSum, maxRightSum), maxLeftBorderSum + maxRightBorderSum);

    }
}
