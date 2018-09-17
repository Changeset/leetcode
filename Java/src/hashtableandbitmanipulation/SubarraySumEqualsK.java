package hashtableandbitmanipulation;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:02 2018/9/14
 * @ ModifiedBy:
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK s = new SubarraySumEqualsK();
        int[] nums = {1,1,1};
        System.out.println(s.subarraySum(nums, 2));
    }
}
