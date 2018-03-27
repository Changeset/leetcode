package arrays;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 20:53 2018/3/27
 * @ ModifiedBy:
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return true;
            if (nums[start] < nums[mid]) {
                if (target < nums[start] || target > nums[mid])
                    start = mid + 1;
                else end = mid - 1;
            } else if (nums[start] > nums[mid]) {
                if (target < nums[mid] || target > nums[end])
                    end = mid - 1;
                else start = mid + 1;
            } else {
                start++;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {1,1,3,1};
        SearchInRotatedSortedArrayII s = new SearchInRotatedSortedArrayII();
        System.out.println(s.search(nums, 3));
    }
}
