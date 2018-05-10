package sortandsearch;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 14:46 2018/5/2
 * @ ModifiedBy:
 */
public class FindMinimumRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        int mid = 0;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            }
            else if (nums[mid] < nums[hi]) {
                hi = mid;
            }
            else hi--;
        }
        return nums[lo];
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,0,1,2};
        FindMinimumRotatedSortedArrayII f = new FindMinimumRotatedSortedArrayII();
        System.out.println(f.findMin(nums));
    }
}

