package arrays;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 20:30 2018/4/9
 * @ ModifiedBy:Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinimumSizeSubSum {
    public int minSubArrayLen(int s, int[] nums) {
        int minLen = Integer.MAX_VALUE, curLen = 0, curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            curLen = i + 1;
            if (curSum >= s) {
                int sum = curSum;
                for (int j = 0; j < i; j++) {
                    sum -= nums[j];
                    if (sum >= s){
                        curLen--;
                        continue;
                    }
                    else break;
                }
                minLen = Math.min(minLen, curLen);
            }
        }
        return minLen > nums.length ? 0 : minLen;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1};
        MinimumSizeSubSum m = new MinimumSizeSubSum();
        System.out.println(m.minSubArrayLen(7,nums));
    }
}
