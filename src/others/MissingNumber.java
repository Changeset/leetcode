package others;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 11:16 2018/3/5
 * @ ModifiedBy:
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }
}
