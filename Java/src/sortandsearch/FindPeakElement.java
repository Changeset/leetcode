package sortandsearch;


/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 18:26 2018/3/19
 * @ ModifiedBy:
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid1 = (lo + hi) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] < nums[mid2])
                lo = mid2;
            else hi = mid1;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        FindPeakElement f = new FindPeakElement();
        System.out.println(f.findPeakElement(nums));
    }
}
