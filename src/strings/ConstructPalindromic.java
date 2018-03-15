package strings;

import java.util.Scanner;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:58 2018/3/15
 * @ ModifiedBy:
 */
public class ConstructPalindromic {
    public static void getResult() {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            System.out.println(str.length() - LCS(str));
        }
        scan.close();
    }

    private static int LCS(String str) {
        String reStr = new StringBuilder(str).reverse().toString();
        int len = str.length();
        int[][] dp = new int[len+1][len+1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                if (str.charAt(i-1) == reStr.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = dp[i-1][j] > dp[i][j-1] ? dp[i-1][j] : dp[i][j-1];
            }
        }
        return dp[len][len];
    }

    public static void main(String[] args) {
        getResult();
    }
}
