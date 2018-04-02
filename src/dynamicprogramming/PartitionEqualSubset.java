package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:16 2018/4/2
 * @ ModifiedBy:
 */
public class PartitionEqualSubset {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        if (sum % 2 > 0) return false;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int num : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i - num];
                }
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        PartitionEqualSubset p = new PartitionEqualSubset();
        int[] nums = {1,5,11,5};
        System.out.println(p.canPartition(nums));
    }
}
