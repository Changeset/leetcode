package others;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 11:08 2018/3/5
 * @ ModifiedBy:
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
