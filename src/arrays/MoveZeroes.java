package arrays;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:47 2018/2/28
 * @ ModifiedBy:
 */
public class MoveZeroes {
    public void MoveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
                count++;
            }
        }
        for (int i = count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
