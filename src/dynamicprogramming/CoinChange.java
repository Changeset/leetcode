package dynamicprogramming;

import java.util.Arrays;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 20:48 2018/3/20
 * @ ModifiedBy:
 */
public class CoinChange {
    int count = 0;
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        Arrays.sort(coins);
        boolean flag = isMakeUp(coins, coins.length - 1, amount, amount);
        if (!flag) return -1;
        else return count;
    }

    public boolean isMakeUp(int[] coins, int end, int amount, int n) {
        if (amount == n) count = 0;
        if (end < 0) return false;
        int endCount = amount / coins[end];
        if (amount % coins[end] == 0) {
            count += endCount;
            return true;
        }
        else {
            for (int i = 0; i < endCount; i++) {
                if (isMakeUp(coins, end-1, leaveChange(coins[end], amount) + coins[end] * i, n)) {
                    count += endCount - i;
                    return true;
                }
            }
            return isMakeUp(coins, end-1, amount, n);
        }
    }
    public int leaveChange(int coins, int amount) {
        return amount % coins;
    }

    public static void main(String[] args) {
        int[] nums = {186, 419, 83, 408};
        CoinChange c = new CoinChange();
        System.out.println(c.coinChange(nums, 6249));
    }
}
