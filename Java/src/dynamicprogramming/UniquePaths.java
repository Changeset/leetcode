package dynamicprogramming;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 19:54 2018/3/20
 * @ ModifiedBy:
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        double res = 1;
        int N = n + m - 2;
        int k = m - 1;
        for (int i = 1; i <= k; i++) {
            res = res * (N - k + i) / i;
        }
        return (int)res;
    }
    /* dynamic programming*/
    public int uniquePathsD(int m, int n) {
        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i++) {
            paths[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            paths[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[i][j] = paths[i-1][j] + paths[i][j-1];
            }
        }
        return paths[m-1][n-1];
    }
    public static void main(String[] args) {
        UniquePaths u = new UniquePaths();
        System.out.println(u.uniquePathsD(10, 10));
    }
}
