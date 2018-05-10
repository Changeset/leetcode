package dynamicprogramming;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 9:25 2018/4/2
 * @ ModifiedBy:
 */
public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < S || (S + sum) % 2 > 0 ? 0 : subsetSum(nums, (S + sum) >>> 1);
    }

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for  (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        TargetSum t = new TargetSum();
        System.out.println(t.findTargetSumWays(nums, 3));
    }
}
