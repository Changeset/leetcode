package dynamicprogramming;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 9:30 2018/5/7
 * @ ModifiedBy:
 */
public class HouseRobberII {
    public int rob(int[] nums, int lo, int hi) {
        int prevNo = 0;
        int prevYes = 0;
        for (int i = lo; i <= hi; i++) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = nums[i] + temp;
        }
        return Math.max(prevNo, prevYes);
    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length -2), rob(nums, 1, nums.length -1));
    }

    public static void main(String[] args) {
        HouseRobberII h = new HouseRobberII();
        int[] nums = {2,3,2};
        System.out.println(h.rob(nums));
    }
}
