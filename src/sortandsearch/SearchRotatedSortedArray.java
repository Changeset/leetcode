package sortandsearch;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:11 2018/3/20
 * @ ModifiedBy:
 */
public class SearchRotatedSortedArray {
//    public int search(int[] nums, int target) {
//        int n = nums.length;
//        int lo = 0, hi = n - 1;
//        if (n == 0) return -1;
//        boolean flag = false;
//        if (nums[lo] < target) flag = false;
//        else if (nums[lo] == target) return 0;
//        else if (nums[hi] < target) return -1;
//        else if (nums[hi] == target) return hi;
//        else flag = true;
//        while (lo <= hi) {
//            int mid = lo + (hi - lo) / 2;
//            if (flag) {
//                if (nums[mid] <= nums[hi]) {
//                    if (nums[mid] < target) {
//                        lo = mid + 1;
//                    } else if (nums[mid] > target){
//                        hi = mid - 1;
//                    } else return mid;
//                } else {
//                    lo = mid + 1;
//                }
//            } else {
//                if (nums[mid] < nums[lo]) {
//                    hi = mid - 1;
//                } else {
//                    if (nums[mid] < target) {
//                        lo = mid + 1;
//                    } else if (nums[mid] > target) {
//                        hi = mid - 1;
//                    } else return mid;
//                }
//            }
//        }
//        return -1;
//    }
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int minIdx = findMinIdx(nums);
        if (target == nums[minIdx]) return minIdx;
        int lo = (target >= nums[0]) ? 0 : minIdx;
        int hi = (target > nums[nums.length - 1]) ? minIdx : nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) hi = mid - 1;
            else if (nums[mid] < target) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public int findMinIdx(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) start = mid + 1;
            else end = mid;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        SearchRotatedSortedArray s = new SearchRotatedSortedArray();
        System.out.println(s.search(nums, 0));
    }
}
