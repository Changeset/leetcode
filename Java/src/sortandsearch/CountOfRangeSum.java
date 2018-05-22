package sortandsearch;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 19:56 2018/5/22
 * @ ModifiedBy:
 */
public class CountOfRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (sums[j] - sums[i] >= lower && sums[j] - sums[i] <= upper)
                    res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountOfRangeSum c = new CountOfRangeSum();
        int[] nums = {-2, 5, -1};
        System.out.println(c.countRangeSum(nums, -2, 2));
    }
}
