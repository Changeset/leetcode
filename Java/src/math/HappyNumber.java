package math;

import java.util.HashSet;
import java.util.Set;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 17:19 2018/3/22
 * @ ModifiedBy:
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            if(set.contains(n)) return false;
            set.add(n);
            n = result(n);
        }
        return true;
    }

    public int result(int n) {
        int res = 0;
        while (n > 0) {
            int num = n % 10;
            res += num * num;
            n = n / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        HappyNumber h = new HappyNumber();
        System.out.println(h.isHappy(11));
    }
}
