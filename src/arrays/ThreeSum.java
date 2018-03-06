package arrays;

import java.util.*;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 14:35 2018/3/5
 * @ ModifiedBy:
 */
public class ThreeSum {
    public List<List<Integer>>  threeSum(int[] nums) {
        if (nums.length == 0) return null;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<Integer>();
            stack = twoSum(nums, i+1, 0-nums[i]);
            if (!stack.isEmpty()) {
                list = stack.pop();
                result.add(list);
            }
        }
        return result;
    }

    public Stack<List<Integer>> twoSum(int[] nums, int indexStart, int result) {
        Stack<List<Integer>> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        for (int i = indexStart; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == result && !set.contains(nums[i])) {
                    list.add(nums[indexStart-1]);
                    set.add(nums[indexStart-1]);
                    set.add(nums[i]);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    stack.push(list);
                }
            }
        }
        return stack;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        ThreeSum s = new ThreeSum();
        List<List<Integer>> result = s.threeSum(nums);
        System.out.println(result);
    }
}
