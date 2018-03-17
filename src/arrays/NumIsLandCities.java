package arrays;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:08 2018/3/17
 * @ ModifiedBy:
 */
public class NumIsLandCities {
    boolean[][] marked = new boolean[100][100];
    public int numIslandCities(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!marked[i][j])
                    count += (dfs(grid, i, j) > 0) ? 1 : 0;
            }
        }
        return count;
    }
    public int dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length) return 0;
        if (col < 0 || col >= grid[0].length) return 0;
        if (grid[row][col] == 0) return 0;
        if (marked[row][col]) return 0;
        if (grid[row][col] >= 1)
            marked[row][col] = true;
        int count = dfs(grid, row-1, col) +
                dfs(grid, row+1, col) +
                dfs(grid, row, col-1) +
                dfs(grid, row, col+1);
        return grid[row][col] > 1 ? count + 1 : count;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,1,0,0,0},
                {0,1,0,0,1},
                {0,0,2,1,2},
                {0,0,0,0,0},
                {0,0,0,0,2}
        };
        NumIsLandCities n = new NumIsLandCities();
        System.out.println(n.numIslandCities(grid));
    }
}
