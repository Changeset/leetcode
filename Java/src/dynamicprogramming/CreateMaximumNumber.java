package dynamicprogramming;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 14:58 2018/5/22
 * @ ModifiedBy:
 */
public class CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] res = new int[k];
        for (int i = Math.max(0, k - m); i <= k && i <= n; i++) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(candidate, 0, res, 0)) res = candidate;
        }
        return res;
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; r++)
            res[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        return res;
    }

    public boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    public int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];
        for (int i = 0, j = 0; i < n; i++) {
            while (n - i + j > k && j > 0 && res[j - 1] < nums[i]) j--;
            if (j < k) res[j++] = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {9,1,2,5,8,3};
        int[] nums2 = {3,4,6,5};
        CreateMaximumNumber c = new CreateMaximumNumber();
        int[] res;
        res = c.maxNumber(nums1, nums2, 5);
        for (int i : res)
            System.out.print(i);
    }
}
