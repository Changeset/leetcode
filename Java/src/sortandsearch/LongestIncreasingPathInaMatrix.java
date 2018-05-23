package sortandsearch;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:36 2018/5/23
 * @ ModifiedBy:
 */
public class LongestIncreasingPathInaMatrix {
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        if (matrix == null || row == 0) return 0;
        int col = matrix[0].length;
        int[][] cache = new int[row][col];
        int max = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int len = dfs(matrix, i, j, row, col, cache);
                max = Math.max(max, len);
            }
        }
        return max;
    }
    private int dfs(int[][] matrix, int i, int j, int row, int col, int[][] cache) {
        if (cache[i][j] != 0) return cache[i][j];
        int max = 1;
        for (int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= row || y < 0 || y >= col || matrix[x][y] <= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, x, y, row, col, cache);
            max = Math.max(max, len);
        }
        cache[i][j] = max;
        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingPathInaMatrix l = new LongestIncreasingPathInaMatrix();
        int[][] nums = {
                {9,9,4},
                {6,6,8},
                {2,1,1}
        };
        System.out.println(l.longestIncreasingPath(nums));
    }
}
