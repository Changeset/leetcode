package arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:44 2018/4/5
 * @ ModifiedBy:
 */
public class Test2 {
    public static void getResult(int a, int b, int x, int y, int k) {
        long[][] dp = new long[101][101];
        dp[0][0] = 1;
        long res = 0;
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) {
                    dp[i][j] = (y - (j - 1)) * dp[i][j-1]/j;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = (x - (i - 1)) * dp[i-1][j]/i;
                    continue;
                }
                long tempy = (y - (j - 1)) * dp[i][j-1]/j;
                long tempx = (x - (i - 1)) * dp[i-1][j]/i;
                dp[i][j] = tempy;
            }
        }
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                if ((i*a + j*b) == k) {
                    res += dp[i][j];
                    res = res % 1000000007;
                }
            }
        }
        System.out.println(res);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int a = sc.nextInt();
        int x = sc.nextInt();
        int b = sc.nextInt();
        int y = sc.nextInt();
        int[][] dp = new int[x+y+1][k+1];

        for (int i = 0; i < x+y+1; i++)
            dp[i][0] = 1;
        for (int i = 1; i < x+y+1; i++) {
            for (int j = 1; j <= k; j++) {
                if (i <= x) {
                    if (j >= a) dp[i][j] = (dp[i-1][j] + dp[i-1][j-a]) % 1000000007;
                    else dp[i][j] = dp[i-1][j] % 1000000007;
                }
                else if (i <= x+y) {
                    if (j >= b) dp[i][j] = (dp[i-1][j] + dp[i-1][j-b]) % 1000000007;
                    else dp[i][j] = dp[i-1][j] % 1000000007;
                }
            }
        }
        System.out.println(dp[x+y][k]);
    }
}
