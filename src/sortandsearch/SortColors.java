package sortandsearch;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:27 2018/3/19
 * @ ModifiedBy:
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int[] result = new int[nums.length];
        int num0 = 0, num1 = 0, num2 = 0;
        for (int num : nums) {
            if (num == 0) num0++;
            if (num == 1) num1++;
            if (num == 2) num2++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < num0) result[i] = 0;
            else if (i >= num0 && i < num1 + num0) result[i] = 1;
            else result[i] = 2;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }
}
