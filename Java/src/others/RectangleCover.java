package others;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 19:43 2018/8/28
 * @ ModifiedBy:
 */
public class RectangleCover {
    public int RectCover(int target) {
        int[] dp = new int[target + 1];
        if (target <= 2) return target;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }

    public static void main(String[] args) {
        RectangleCover r = new RectangleCover();
        System.out.println(r.RectCover(3));
    }
}
