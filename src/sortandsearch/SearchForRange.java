package sortandsearch;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 21:05 2018/3/19
 * @ ModifiedBy:
 */
public class SearchForRange {
    public int[] searchRange(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        int[] result = new int[2];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            }
            if (nums[mid] > target) {
                hi = mid - 1;
            }
            if (nums[mid] == target) {
                result[0] = mid;
                result[1] = mid;
                break;
            }
        }
        int i, j;

    }
}
