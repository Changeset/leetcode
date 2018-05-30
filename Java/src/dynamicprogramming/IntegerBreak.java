package dynamicprogramming;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 14:27 2018/5/30
 * @ ModifiedBy:
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int product = 1;
        while (n > 4) {
            product *= 3;
            n -= 3;
        }
        product *= n;
        return product;
    }

    public static void main(String[] args) {
        IntegerBreak i = new IntegerBreak();
        System.out.println(i.integerBreak(10));
    }
}
