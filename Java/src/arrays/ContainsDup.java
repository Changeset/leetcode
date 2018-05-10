package arrays;

import java.util.TreeMap;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 20:28 2018/2/27
 * @ ModifiedBy:
 */
public class ContainsDup {
    public boolean containsDuplicate(int[] nums) {
        TreeMap<Integer, Boolean> map = new TreeMap<Integer, Boolean>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null)
                map.put(nums[i], true);
            else
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        ContainsDup cd = new ContainsDup();
        int[] nums = {3,1};
        System.out.println(cd.containsDuplicate(nums));
    }
}
