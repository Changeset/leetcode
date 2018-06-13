package dynamicprogramming;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 9:23 2018/6/13
 * @ ModifiedBy:
 */
public class PredicttheWinner {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }

    public static void main(String[] args) {
        PredicttheWinner p = new PredicttheWinner();
        int[] nums = {1,5,2};
        System.out.println(p.PredictTheWinner(nums));
    }
}
