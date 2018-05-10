package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 11:27 2018/3/19
 * @ ModifiedBy:
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
//        Arrays.sort(nums);
        backtracking(res, new ArrayList<>(), 0, nums);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> tempList, int start, int[] nums) {
        res.add(new ArrayList<>(tempList));

        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtracking(res, tempList, i + 1, nums);
            tempList.remove(tempList.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Subsets s = new Subsets();
        System.out.println(s.subsets(nums));
    }

}
