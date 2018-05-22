package sortandsearch;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 18:50 2018/5/22
 * @ ModifiedBy:
 */
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;

        int left = 0, i = 0, right = n - 1;

        while (i <= right) {
            if (nums[newIndex(i, n)] > median) {
                exch(nums, newIndex(left++, n), newIndex(i++, n));
            }
            else if (nums[newIndex(i, n)] < median) {
                exch(nums, newIndex(right--, n), newIndex(i,n));
            }
            else i++;
        }
    }

    private int newIndex(int index, int n) {
        return (1 + 2 * index) % (n  | 1);
    }

    public int findKthLargest(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        int res = partition(nums, start, end);
        while (res != k - 1) {
            if (res < k - 1) {
                start = res + 1;
                res = partition(nums, start, end);
            } else if (res > k - 1) {
                end = res - 1;
                res = partition(nums, start, end);
            }
        }
        return nums[res];
    }
    public int partition(int[] nums, int lo, int hi) {
        if (lo == hi) return lo;
        int i = lo;
        int j = hi + 1;
        int sentinel = nums[lo];
        while (true) {
            while (nums[++i] > sentinel)
                if (i == hi) break;
            while (nums[--j] <= sentinel)
                if (j == lo) break;
            if (i >= j) break;
            exch(nums, i, j);
        }
        exch(nums, lo, j);
        return j;
    }

    public void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
