package arrays;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 20:01 2018/3/14
 * @ ModifiedBy:
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int minLeft = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        if (nums.length < 3) return false;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > mid) return true;
            minLeft = Math.min(nums[i-1], minLeft);
            if (minLeft < nums[i]) {
                mid = Math.min(nums[i], mid);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,1,5,2,3};
        IncreasingTripletSubsequence i = new IncreasingTripletSubsequence();
        System.out.println(i.increasingTriplet(nums));
    }
}
