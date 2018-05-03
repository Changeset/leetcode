package dynamicprogramming;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:26 2018/5/3
 * @ ModifiedBy:
 */
public class BestTimeBuySellStockIV {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return quickSolve(prices);
        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax = -prices[0];
            for (int j = 1; j < len; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax = Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][len - 1];
    }

    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i-1];
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {3,6,5,0,2,4};
        BestTimeBuySellStockIV v = new BestTimeBuySellStockIV();
        System.out.println(v.maxProfit(2, prices));
    }
}
