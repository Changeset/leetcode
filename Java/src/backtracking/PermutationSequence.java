package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 20:02 2018/4/10
 * @ ModifiedBy:
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> num = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            num.add(i);
        }
        for (int i = 0, l = k - 1; i < n; i++) {
            fact /= (n - i);
            int index = (l / fact);
            sb.append(num.remove(index));
            l -= index * fact;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        PermutationSequence p = new PermutationSequence();
        System.out.println(p.getPermutation(3,2));
    }
}
