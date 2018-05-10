package dynamicprogramming;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:54 2018/3/3
 * @ ModifiedBy:
 */
public class MaximumSubarray {
//    public int maxSubArray(int[] nums) {
//        int maxCur = Integer.MIN_VALUE, addedNum = 0, maxSoFar = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            addedNum = maxCur > 0 ? addedNum + nums[i] : Math.max(0, nums[i]);
//            if (addedNum == 0) maxCur = Math.max(maxCur, nums[i]);
//            else if (addedNum > 0) maxCur = addedNum;
//            else maxCur = 0;
//            maxSoFar = Math.max(maxCur, maxSoFar);
//        }
//        return maxSoFar;
//    }
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0], maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(maxEndingHere+nums[i], nums[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }
    public int maxProfit(int[] nums) {
        int maxCur = 0, maxSoFar = 0;
        for (int i = 0; i < nums.length-1; i++) {
            maxCur = Math.max(0, maxCur += nums[i+1]-nums[i]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaximumSubarray m = new MaximumSubarray();
        System.out.println(m.maxSubArray(nums));
        System.out.println(m.maxProfit(nums));
    }
}
