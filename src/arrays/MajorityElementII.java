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
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > nums.length / 3) res.add(e.getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,2,2,2};
        MajorityElementII m = new MajorityElementII();
        System.out.println(m.majorityElement(nums));
    }
}
