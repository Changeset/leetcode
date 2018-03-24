package math;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 14:10 2018/3/24
 * @ ModifiedBy:
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            res += n / 5;
            n = n / 5;
        }
        return res;
    }

    public static void main(String[] args) {
        FactorialTrailingZeroes f = new FactorialTrailingZeroes();
        System.out.println(f.trailingZeroes(25));
    }
}
