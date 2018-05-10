package arrays;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 21:12 2018/2/27
 * @ ModifiedBy:
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int number = 0;
        for (int i = 0; i < n; i++) {
            number ^= nums[i];
        }
        return number;
    }
}
