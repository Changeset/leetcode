package dynamicprogramming;

import java.util.Arrays;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 20:48 2018/3/20
 * @ ModifiedBy:
 */
public class CoinChange {
//    public int coinChange(int[] coins, int amount) {
//        if (amount < 1) return 0;
//        return coinChange(coins, amount, new int[amount]);
//    }
//
//    private int coinChange(int[] coins, int rem, int[] count) {
//        if (rem < 0) return -1;
//        if (rem == 0) return 0;
//        if (count[rem - 1] != 0) return count[rem - 1];
//        int min = Integer.MAX_VALUE;
//        for (int coin : coins) {
//            int res = coinChange(coins, rem - coin, count);
//            if (res >= 0 && res < min) min = 1 + res;
//        }
//        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
//        return count[rem - 1];
//    }
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
    public static void main(String[] args) {
        int[] nums = {346, 29, 395, 188, 155, 109};
        CoinChange c = new CoinChange();
        System.out.println(c.coinChange(nums, 9401));
    }
}
