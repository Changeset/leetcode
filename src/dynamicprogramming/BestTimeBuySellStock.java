package dynamicprogramming;

import tree.BinaryTreeInorderTraversal;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 20:51 2018/3/2
 * @ ModifiedBy:
 */
public class BestTimeBuySellStock {
//    public int maxProfit(int[] prices) {
//        boolean flag = false;
//        for (int i = 0; i < prices.length-1; i++){
//            if (prices[i+1] - prices[i] > 0) {
//                flag = true;
//                break;
//            }
//        }
//        if (!flag) return 0;
//        else return helper(prices, 0, prices.length-1);
//    }
//
//    public int helper(int[] prices, int lo, int hi) {
//        int result = 0, minmum = Integer.MAX_VALUE, maxmum = Integer.MIN_VALUE;
//        int indexmin = 0, indexmax = 0;
//        if (lo >= hi) return 0;
//        for (int i = lo; i <= hi; i++) {
//            if (minmum != Math.min(minmum, prices[i])){
//                indexmin = i;
//                minmum = Math.min(minmum, prices[i]);
//            }
//            if (maxmum != Math.max(maxmum, prices[i])){
//                indexmax = i;
//                maxmum = Math.max(maxmum, prices[i]);
//            }
//        }
//        if (indexmin <= indexmax) return maxmum - minmum;
//        else {
//            result = Math.max(helper(prices, lo, indexmax), helper(prices, indexmax+1, indexmin-1));
//            result = Math.max(result, helper(prices, indexmin, hi));
//            return result;
//        }
//    }
    public int maxProfit(int[] prices) {
        int maxCur = 0, maxRes = 0;
        for (int i = 0; i < prices.length-1; i++) {
            maxCur = Math.max(0, maxCur+=prices[i+1]-prices[i]);
            maxRes = Math.max(maxCur, maxRes);
        }
        return maxRes;
    }
    public static void main(String[] args) {
        int[] nums = {8,6,4,3,3,2,3,5,8,3,8,2,6};
        BestTimeBuySellStock b = new BestTimeBuySellStock();
        System.out.println(b.maxProfit(nums));
    }
}
