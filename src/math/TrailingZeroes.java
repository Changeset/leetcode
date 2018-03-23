package math;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 20:31 2018/3/23
 * @ ModifiedBy:
 */
public class TrailingZeroes {
    public int trailingZeroes(int n) {
        int res = 0;
        res = n / 5;
        for (int i = 1; i <= n / 5; i++) {
            int temp = i;
            while (temp >= 5 && temp % 5 == 0) {
                temp /= 5;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TrailingZeroes t = new TrailingZeroes();
        System.out.println(t.trailingZeroes(50));
    }
}
