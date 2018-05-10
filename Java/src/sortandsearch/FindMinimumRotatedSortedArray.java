package sortandsearch;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 14:40 2018/5/2
 * @ ModifiedBy:
 */
public class FindMinimumRotatedSortedArray {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) start = mid + 1;
            else end = mid;
        }
        return nums[start];
    }

    public int findMinidx(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end -start) / 2;
            if (nums[mid] > nums[end]) start = mid + 1;
            else end = mid;
        }
        return nums[start];
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,1,2,3};
        FindMinimumRotatedSortedArray f = new FindMinimumRotatedSortedArray();
        System.out.println(f.findMin(nums));
    }
}
