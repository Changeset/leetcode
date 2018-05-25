package dynamicprogramming;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:34 2018/5/25
 * @ ModifiedBy:
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i = 1; i < num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }
}
