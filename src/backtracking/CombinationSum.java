package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:44 2018/3/24
 * @ ModifiedBy:
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:
 [
 [7],
 [2, 2, 3]
 ]
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    public void backtrack(int[] candidates, int start, int target, List<Integer> path, List<List<Integer>> res) {
        if (target < 0) return;
        else if (target == 0) res.add(new ArrayList<>(path));
        else {
            for (int i = start; i < candidates.length; i++) {
                path.add(candidates[i]);
                backtrack(candidates, i + 1, target - candidates[i], path, res);
                path.remove(path.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        int[] b = {1,4,2,3,5};
        CombinationSum s = new CombinationSum();
        System.out.println(s.combinationSum(b, 5));
    }
}
