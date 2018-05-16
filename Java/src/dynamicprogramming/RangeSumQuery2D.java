package dynamicprogramming;

import java.util.Arrays;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 9:35 2018/5/16
 * @ ModifiedBy:
 */
public class RangeSumQuery2D {
    private int row, col;
    private int[][] sums;
    public RangeSumQuery2D(int[][] matrix) {
        row = matrix.length;
        col = row > 0 ? matrix[0].length : 0;
        sums = new int[row + 1][col + 1];
        for (int[] s : sums) {
            Arrays.fill(s, 0);
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                sums[i][j] = matrix[i-1][j-1] +
                            sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2+1][col2+1] - sums[row2+1][col1] - sums[row1][col2+1] + sums[row1][col1];
    }

}
