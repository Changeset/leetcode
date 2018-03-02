package dynamicprogramming;

import tree.BinaryTreeInorderTraversal;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 20:51 2018/3/2
 * @ ModifiedBy:
 */
public class BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        int result = 0, min = 0, index = 0;
        int i = 0, j = prices.length - 1;
        while (true) {
            for (int m = 0; m < j; m++) {
                min = Math.min(min, prices[m]);
                index = m;
            }
            for (int n = j; j > index; j--) {
                result = Math.max(prices[j]-min, result);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3,6,4};
        BestTimeBuySellStock b = new BestTimeBuySellStock();
        System.out.println(b.maxProfit(nums));
    }
}
