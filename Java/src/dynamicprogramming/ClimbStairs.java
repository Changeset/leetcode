package dynamicprogramming;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 20:40 2018/3/2
 * @ ModifiedBy:
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        int f[] = new int[n+1];
        f[1] = 1;
        f[2] = 2;
        if (n <= 2) return f[n];
        for (int i = 3; i <= n; i++) {
            f[i] = f[n-1] + f[n-2];
        }
        return f[n+1];
    }
}
