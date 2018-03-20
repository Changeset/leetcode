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
        result[0] = -1;
        result[1] = -1;
        if (nums.length == 0) return result;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            }
            if (nums[mid] > target) {
                hi = mid - 1;
            }
            if (nums[mid] == target) {
                hi = mid;
            }
        }
        if (lo >= hi && nums[lo] != target) {
            return result;
        }
        if (lo == hi && nums[lo] == target) {
            result[0] = lo;
            result[1] = lo;
        }
        lo = 0;
        hi = nums.length - 1;
        while (lo < hi) {
            int mid = hi - (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            }
            if (nums[mid] > target) {
                hi = mid - 1;
            }
            if (nums[mid] == target) {
                lo = mid;
            }
        }
        if (lo == hi) {
            result[1] = hi;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,2};
        SearchForRange s = new SearchForRange();
        System.out.println(s.searchRange(nums, 1));
    }
}
