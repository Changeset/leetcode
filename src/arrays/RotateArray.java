package arrays;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 20:24 2018/2/27
 * @ ModifiedBy:
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] aux = new int[n];
        for (int i = 0; i < n; i++) {
            aux[(i+k)%n] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = aux[i];
        }
    }
}
