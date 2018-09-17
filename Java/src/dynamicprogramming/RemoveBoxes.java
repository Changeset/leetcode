package dynamicprogramming;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:18 2018/9/9
 * @ ModifiedBy:
 */
public class RemoveBoxes {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return removeBoxesSub(boxes, 0, n - 1, 0, dp);
    }

    private int removeBoxesSub(int[] boxes, int i, int j, int k, int[][][] dp) {
        if (i > j) return 0;
        if (dp[i][j][k] > 0) return dp[i][j][k];

        for (; i + 1 <= j && boxes[i + 1] == boxes[i]; i++, k++);
        int res = (k + 1) * (k + 1) + removeBoxesSub(boxes, i + 1, j, 0, dp);

        for (int m = i + 1; m <= j; m++) {
            if (boxes[i] == boxes[m]) {
                res = Math.max(res, removeBoxesSub(boxes, i + 1, m - 1, 0, dp) + removeBoxesSub(boxes, m, j, k + 1, dp));
            }
        }

        dp[i][j][k] = res;
        return res;
    }

    public static void main(String[] args) {
        RemoveBoxes r = new RemoveBoxes();
        int[] boxes = {1,3,2,2,2,3,4,3,1};
        System.out.println(r.removeBoxes(boxes));
    }
}
