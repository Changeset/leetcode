package sortandsearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 9:15 2018/6/14
 * @ ModifiedBy:
 */
public class IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<List<Integer>>();
        List<Integer> holder = new ArrayList<>();
        findSequence(res, holder, 0, nums);
        List result = new ArrayList(res);
        return result;
    }

    private void findSequence(Set<List<Integer>> res, List<Integer> holder, int index, int[] nums) {
        if (holder.size() >= 2) res.add(new ArrayList<>(holder));
        for (int i = index; i < nums.length; i++) {
            if (holder.size() == 0 || holder.get(holder.size() - 1) <= nums[i]) {
                holder.add(nums[i]);
                findSequence(res, holder, i + 1, nums);
                holder.remove(holder.size() - 1);
            }
        }
    }
}
