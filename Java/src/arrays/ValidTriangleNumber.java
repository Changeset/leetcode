package arrays;

import java.util.Arrays;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 14:49 2018/9/21
 * @ ModifiedBy:
 */
public class ValidTriangleNumber {
    public static int triangleNumber(int[] A) {
        Arrays.sort(A);
        int count = 0, n = A.length;
        for (int i = n - 1; i >= 2; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (A[l] + A[r] > A[i]) {
                    count += r - l;
                    r--;
                }
                else l++;
            }
        }
        return count;
    }
}
