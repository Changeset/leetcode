package arrays;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 20:59 2018/4/2
 * @ ModifiedBy:
 */
public class MaximumDays {
    public int maximumDays(int[] height, int numOfPlants) {
        int minLeft = Integer.MAX_VALUE, minCur = Integer.MAX_VALUE;
        int[] dp = new int[numOfPlants];
        dp[0] = 0;
        for (int i = 1; i < numOfPlants; i++) {
            minLeft = Math.min(minLeft, height[i - 1]);
            if (height[i] > height[i - 1]) {
                dp[i] = Math.max(dp[i - 1], 1);
            }
            else {
                if (height[i] > minCur) {
                    dp[i] = dp[i - 1];
                }
                else {
                    if (height[i] > minLeft) {
                        dp[i] = dp[i - 1] + 1;
                        minCur = height[i];
                    } else dp[i] = dp[i - 1];
                }
            }
        }
        return dp[numOfPlants - 1];
    }

    public static void main(String[] args) {
        int[] nums = {3,6,9,8};
        MaximumDays m = new MaximumDays();
        System.out.println(m.maximumDays(nums, nums.length));
    }
}
