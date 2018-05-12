package dynamicprogramming;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 13:26 2018/5/12
 * @ ModifiedBy:
 */
public class PerfectSquares {
    public int numSquares(int n) {
        if (n <= 0) return 0;
        int[] cntPerfectSquares = new int[n + 1];
        Arrays.fill(cntPerfectSquares, Integer.MAX_VALUE);
        cntPerfectSquares[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j*j <= i; j++) {
                cntPerfectSquares[i] =
                        Math.min(cntPerfectSquares[i], cntPerfectSquares[i - j*j] + 1);
            }
        }
        return cntPerfectSquares[n];
    }

    public static void main(String[] args) {
        PerfectSquares p = new PerfectSquares();
        System.out.println(p.numSquares(12));
    }
}
