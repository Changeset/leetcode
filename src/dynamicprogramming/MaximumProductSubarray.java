package dynamicprogramming;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:07 2018/3/29
 * @ ModifiedBy:
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int maxPro = Integer.MIN_VALUE, imax = nums[0], imin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);

            maxPro = Math.max(imax, maxPro);
        }
        return maxPro;
    }

    public static void main(String[] args) {
        MaximumProductSubarray m = new MaximumProductSubarray();
        int[] nums = {2,3,-2,4,-2};
        System.out.println(m.maxProduct(nums));
    }
}
