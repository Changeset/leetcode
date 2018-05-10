package dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 9:48 2018/4/23
 * @ ModifiedBy:
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<Integer> minlen = new ArrayList<>(triangle.get(n-1));
        for (int layer = n - 2; layer >= 0; layer--) {
            for (int i = 0; i <= layer; i++) {
                minlen.set(i, Math.min(minlen.get(i), minlen.get(i+1)) + triangle.get(layer).get(i));
            }
        }
        return minlen.get(0);
    }
}
