package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:33 2018/5/7
 * @ ModifiedBy:
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(res, path, 0, k, n);
        return res;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> path, int num, int k, int target) {
        if (k == 0 && target == 0) {
            List<Integer> temp = new ArrayList<>(path);
            result.add(temp);
            return;
        }
        for (int i = num + 1; i <= 9; i++) {
            path.add(i);
            backtrack(result, path, i, k - 1, target - i);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumIII c = new CombinationSumIII();
        System.out.println(c.combinationSum3(3,7));
    }
}
