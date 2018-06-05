package dynamicprogramming;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 11:02 2018/6/5
 * @ ModifiedBy:
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int curr = 0, sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                curr++;
                sum += curr;
            } else curr = 0;
        }
        return sum;
    }

    public static void main(String[] args) {
        ArithmeticSlices a = new ArithmeticSlices();
        System.out.println(a.numberOfArithmeticSlices(new int[] {1,2,3,4,5}));
    }
}
