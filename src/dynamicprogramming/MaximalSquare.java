package dynamicprogramming;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:45 2018/5/8
 * @ ModifiedBy:
 */
public class MaximalSquare {
    public int maximalSquare1(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] size = new int[m][n];
        int maxsize = 0;
        for (int j = 0; j < n; j++) {
            size[0][j] = matrix[0][j] - '0';
            maxsize = Math.max(maxsize, size[0][j]);
        }
        for (int i = 1; i < m; i++) {
            size[i][0] = matrix[i][0] - '0';
            maxsize = Math.max(maxsize, size[i][0]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    size[i][j] = Math.min(size[i - 1][j - 1], Math.min(size[i - 1][j], size[i][j - 1])) + 1;
                    maxsize = Math.max(maxsize, size[i][j]);
                }
            }
        }
        return maxsize * maxsize;
    }
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] dp = new int[m + 1];
        int maxsize = 0, pre = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 1; i <= m; i++) {
                int temp = dp[i];
                if (matrix[i - 1][j] == '1') {
                    dp[i] = Math.min(dp[i], Math.min(dp[i - 1], pre)) + 1;
                    maxsize = Math.max(maxsize, dp[i]);
                }
                else dp[i] = 0;
                pre = temp;
            }
        }
        return maxsize * maxsize;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '0', '0', '1'},
                {'1', '1', '1', '1', '0'},
                {'0', '0', '1', '1', '1'},
                {'1', '0', '0', '0', '1'}
        };
        MaximalSquare m = new MaximalSquare();
        System.out.println(m.maximalSquare(matrix));
    }
}
