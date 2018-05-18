package dynamicprogramming;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:49 2018/5/18
 * @ ModifiedBy:
 */
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int[] iNums = new int[nums.length + 2];
        int n = 1;
        for (int x : nums)
            if (x > 0) iNums[n++] = x;
        iNums[0] = iNums[n++] = 1;

        int[][] dp = new int[n][n];
        for (int k = 2; k < n; k++) {
            for (int left = 0; left < n - k; left++) {
                int right = left + k;
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right],
                            iNums[left] * iNums[i] * iNums[right] + dp[left][i] + dp[i][right]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
