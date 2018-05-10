package backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 9:38 2018/4/15
 * @ ModifiedBy:
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        if (k > n) return res;
        backtrack(res, new LinkedList<>(), k, 1, n);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> list, int k, int start, int n) {
        if (k == 0) {
            List<Integer> temp = new LinkedList<>(list);
            res.add(temp);
            return ;
        }
        if (start > n) return;
        for (int i = start; i <= n; i++) {
            list.add(i);
            backtrack(res, list, k-1, i+1, n);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations c = new Combinations();
        System.out.println(c.combine(4, 2));
    }
}
