package dynamicprogramming;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 9:38 2018/5/17
 * @ ModifiedBy:
 */
public class BestTimeBuySellStockCooldown {
    public int maxProfit(int[] prices) {
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        BestTimeBuySellStockCooldown b = new BestTimeBuySellStockCooldown();
        System.out.println(b.maxProfit(prices));
    }
}
