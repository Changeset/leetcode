package arrays;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:01 2018/9/12
 * @ ModifiedBy:
 */
public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid % 2 == 1) mid--;
            if (nums[mid] != nums[mid + 1]) end = mid;
            else start = mid + 2;
        }
        return nums[start];
    }
}
