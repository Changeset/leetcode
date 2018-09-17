package sortandsearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:48 2018/9/10
 * @ ModifiedBy:
 */
public class Matrix01 {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                if (r < 0 || r >= m || c < 0 || c >= n ||
                        matrix[r][c] <= matrix[cell[0]][cell[1]] + 1) continue;
                queue.add(new int[] {r, c});
                matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Matrix01 m = new Matrix01();
        int[][] matrix = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] res = m.updateMatrix(matrix);
        for (int[] t : matrix) {
            for (int i : t) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
