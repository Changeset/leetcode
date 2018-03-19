package sortandsearch;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:27 2018/3/19
 * @ ModifiedBy:
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int p1 = 0, p2 = nums.length-1, index = 0;
        while (index <= p2) {
            if (nums[index] == 0) {
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            if (nums[index] == 2) {
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index--;
            }
            index++;
        }
    }
    public static void main(String[] args) {
        int[] nums = {2,1,0,0,2,1,0,1};
        SortColors s = new SortColors();
        s.sortColors(nums);
    }
}
