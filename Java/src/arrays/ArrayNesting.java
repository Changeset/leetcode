package arrays;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:34 2018/9/14
 * @ ModifiedBy:
 */
public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        int maxsize = 0;
        for (int i = 0; i < nums.length; i++) {
            int size = 0;
            for (int k = i; nums[k] >= 0; size++) {
                int numsk = nums[k];
                nums[k] = -1;
                k = numsk;
            }
            maxsize = Math.max(maxsize, size);
        }
        return maxsize;
    }

    public static void main(String[] args) {
        ArrayNesting a = new ArrayNesting();
    }
}
