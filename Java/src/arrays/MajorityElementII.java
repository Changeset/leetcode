package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 20:27 2018/5/8
 * @ ModifiedBy:
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) return res;
        int num1 = nums[0];
        int num2 = nums[0], count1 = 1, count2 = 0;
        for (int val : nums) {
            if (val == num1) count1++;
            else if (val == num2) count2++;
            else if (count1 == 0) {
                num1 = val;
                count1++;
            }
            else if (count2 == 0) {
                num2 = val;
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int val : nums) {
            if (val == num1) count1++;
            else if (val == num2) count2++;
        }
        if (count1 > nums.length/3) res.add(num1);
        if (count2 > nums.length/3) res.add(num2);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,2,2,2};
        MajorityElementII m = new MajorityElementII();
        System.out.println(m.majorityElement(nums));
    }
}
