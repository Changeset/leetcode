package math;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 14:43 2018/5/20
 * @ ModifiedBy:
 */
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        res[0] = 1;
        int[] cur = new int[primes.length];

        for (int i = 1; i < n; i++) {
            res[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                if (primes[j] * res[cur[j]] == res[i - 1]) {
                    cur[j]++;
                }
                res[i] = Math.min(res[i], primes[j] * res[cur[j]]);
            }
        }
        return res[n - 1];
    }

    public static void main(String[] args) {
        int[] primes = {2, 7, 13, 19};
        SuperUglyNumber s = new SuperUglyNumber();
        System.out.println(s.nthSuperUglyNumber(12, primes));
    }
}
