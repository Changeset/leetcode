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
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            int front = i + 1;
            int back = nums.length-1;
            while (front < back) {
                int sum = nums[front] + nums[back];
                if (sum < target) front++;
                else if (sum > target) back--;
                else {
                    List<Integer> list = new ArrayList<Integer>(3);
                    list.size();
                    list.add(nums[i]);
                    list.add(nums[front]);
                    list.add(nums[back]);
                    res.add(list);
                    while (front < back && nums[front] == list.get(1)) front++;
                    while (front < back && nums[back] == list.get(2)) back--;
                }
                while(i + 1 < nums.length && nums[i] == nums[i+1])
                    i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,1,-1,2,-1, -4};
        ThreeSum s = new ThreeSum();
        List<List<Integer>> result = s.threeSum(nums);
        System.out.println(result);
    }
}
