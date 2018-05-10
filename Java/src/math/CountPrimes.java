package math;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:43 2018/3/5
 * @ ModifiedBy:
 */
public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n+1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] =true;
        }

        for (int factor = 2; factor * factor <= n; factor++) {
            if (isPrime[factor]) {
                for (int j = factor; factor*j <= n; j++) {
                    isPrime[factor*j] = false;
                }
            }
        }

        int primes = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes++;
            }
        }
        return primes;
    }
}
