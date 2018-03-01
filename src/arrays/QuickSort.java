package arrays;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 21:26 2018/2/27
 * @ ModifiedBy:
 */
public class QuickSort {
    public int partition(int[] nums, int start, int end) {
        if (nums == null || start < 0 || end >= nums.length)
            throw new IllegalArgumentException();
        int small = start - 1;
        for (int index = start; index < end; index++) {
            if (nums[index] < nums[end]) {
                ++small;
                if (small != index) {
                    exch(nums, index, small);
                }
            }
        }
        ++small;
        exch(nums, small, end);
        return small;
    }

    private static void exch(int[] nums, int i, int j) {
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
    }
}
