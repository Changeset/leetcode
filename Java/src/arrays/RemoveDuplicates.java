package arrays;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 19:32 2018/2/27
 * @ ModifiedBy:
 */
public class RemoveDuplicates {
    public int removeDepulicates(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int lastnum = nums[0];
        int count = 1;
        for (int i = 0 ; i < n; i++) {
            if (lastnum != nums[i]) {
                count++;
                lastnum = nums[i];
                exch(nums, i, count-1);
            }
        }
        return count;
    }

    private void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}

