package dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 14:44 2018/5/28
 * @ ModifiedBy:
 */
public class MaxSumOfRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length == 0) return 0;
        int row = matrix.length, col = matrix[0].length, res = Integer.MIN_VALUE;
        for (int left = 0; left < col; left++) {
            int[] sums = new int[row];
            for (int right = left; right < col; right++) {
                for (int i = 0; i < row; i++)
                    sums[i] += matrix[i][right];

                TreeSet<Integer> set = new TreeSet<Integer>();
                set.add(0);
                int currSum = 0;
                for (int sum : sums) {
                    currSum += sum;
                    Integer num = set.ceiling(currSum - k);
                    if (num != null) res = Math.max(res, currSum - num);
                    set.add(currSum);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0 ,1},
                {0, -2, 3}
        };
        MaxSumOfRectangleNoLargerThanK m = new MaxSumOfRectangleNoLargerThanK();
        System.out.println(m.maxSumSubmatrix(matrix, 2));
    }
}
