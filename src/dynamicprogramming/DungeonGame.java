package dynamicprogramming;

import java.util.Arrays;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 19:24 2018/5/2
 * @ ModifiedBy:
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int M = dungeon.length;
        int N = dungeon[0].length;
        // hp[i][j] represents the min hp needed at position (i, j)
        // Add dummy row and column at bottom and right side
        int[][] hp = new int[M+1][N+1];
        for (int[] h : hp)
            Arrays.fill(h, Integer.MAX_VALUE);
        hp[M][N-1] = 1;
        hp[M-1][N] = 1;
        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                int need = Math.min(hp[i+1][j], hp[i][j+1]) - dungeon[i][j];
                hp[i][j] = need <= 0 ? 1 : need;
            }
        }
        return hp[0][0];
    }
}