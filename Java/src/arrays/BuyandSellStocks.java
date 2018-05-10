package arrays;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 20:23 2018/2/27
 * @ ModifiedBy:
 */
public class BuyandSellStocks {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i-1] < prices[i])
                res += prices[i] - prices[i-1];
            else continue;
        }
        return res;
    }
}
