package hashtableandbitmanipulation;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 18:43 2018/5/3
 * @ ModifiedBy:
 */
public class BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) return 0;
        int moveFactor = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }
        return m * moveFactor;
    }
}
