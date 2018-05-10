package dynamicprogramming;

import java.util.Arrays;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 8:57 2018/3/21
 * @ ModifiedBy:
 */
public class LongestIncreasingSubseq {
    public int lengthOfLISmyDP(int[] nums) {
        if (nums.length == 0) return 0;
        int maxLength = 0;
        int[][] result = new int[nums.length][2];
        result[nums.length - 1][0] = nums.length - 1;
        result[nums.length - 1][1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int curLength = result[result[i + 1][0]][1];
            result[i][1] = 1;
            result[i][0] = result[i+1][0];
            int curLength1 = 1;
            int max = result[result[i][0]][1];
            int max1 = Integer.MIN_VALUE;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    if (curLength1 < result[j][1] + 1) {
                        curLength1 = result[j][1] + 1;
                    }
                    if (curLength1 > max1) {
                        max1 = curLength1;
                        result[i][1] = max1;
                    }
                    if (curLength < result[j][1] + 1) {
                        curLength = result[j][1] + 1;
                    }
                    if (curLength > max) {
                        max = curLength;
                        result[i][0] = i;
                    }
                }
            }
        }
        return result[result[0][0]][1];
    }

    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    public int lengthOfLISDP(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i+1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
    public static void main(String[] args) {
        int[] nums = {0,8,4,12,2};
        LongestIncreasingSubseq l = new LongestIncreasingSubseq();
        System.out.println(l.lengthOfLISDP(nums));
    }
}
