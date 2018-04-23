package dynamicprogramming;

import java.util.Arrays;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 9:17 2018/4/23
 * @ ModifiedBy:
 */
public class DistinctSubsequence {
    public int numDistinct(String S, String T) {
        //array creation
        int[][] mem = new int[T.length() + 1][S.length() + 1];

        //filling the first row: with 1s
        for (int j = 0; j < S.length(); j++) {
            mem[0][j] = 1;
        }

        //the first column is 0 by default in
        for (int i = 0; i < T.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                if (T.charAt(i) == S.charAt(j)) {
                    mem[i+1][j+1] = mem[i][j] + mem[i+1][j];
                } else {
                    mem[i+1][j+1] = mem[i+1][j];
                }
            }
        }
        return mem[T.length()][S.length()];
    }

    public int numDistinct1(String S, String T) {
        int[] f1 = new int[S.length()];
        int[] f2 = new int[S.length()];
        Arrays.fill(f1, 0);
        Arrays.fill(f2, 1);
        for (int i = 0; i < T.length(); i++) {
            for (int j = i; j < S.length(); j++) {
                if (T.charAt(i) == S.charAt(j)) {
                    if (j - 1 < 0) f1[j] = 1;
                    else f1[j] = f2[j-1] + f1[j-1];
                }
                else {
                    if (j - 1 < 0) f1[j] = 0;
                    else f1[j] = f1[j-1];
                }
            }
            for (int k = 0; k < S.length(); k++) {
                f2[k] = f1[k];
                f1[k] = 0;
            }
        }
        if (S.length() == 0) return 0;
        else return f2[S.length() - 1];
    }
}
