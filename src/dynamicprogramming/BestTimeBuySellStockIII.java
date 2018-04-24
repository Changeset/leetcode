package dynamicprogramming;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 18:08 2018/4/23
 * @ ModifiedBy:
 */
public class BestTimeBuySellStockIII {
    public int maxProfit(int[] prices) {
        int lowestBuyPrice1 = Integer.MIN_VALUE, lowestBuyPrice2 = Integer.MIN_VALUE;
        int maxProfit1 = 0, maxProfit2 = 0;
        for(int i : prices){                              // Assume we only have 0 money at first
            maxProfit2         = Math.max(maxProfit2, lowestBuyPrice2 + i);     // The maximum if we've just sold 2nd stock so far.
            lowestBuyPrice2    = Math.max(lowestBuyPrice2, maxProfit1 - i);  // The maximum if we've just buy  2nd stock so far.
            maxProfit1         = Math.max(maxProfit1, lowestBuyPrice1 + i);     // The maximum if we've just sold 1nd stock so far.
            lowestBuyPrice1    = Math.max(lowestBuyPrice1,    -i);          // The maximum if we've just buy  1st stock so far.
        }
        return maxProfit2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        BestTimeBuySellStockIII b = new BestTimeBuySellStockIII();
        System.out.println(b.maxProfit(prices));
    }
}
