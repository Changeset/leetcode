package strings;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:17 2018/3/1
 * @ ModifiedBy:
 */
public class ReverseInteger {
    public int reverse(int x) {
        long b = 0;
        while(x != 0) {
            b*=10;
            b += x%10;
            if (b > Integer.MAX_VALUE) return 0;
            x /= 10;
        }
        if (b > Integer.MAX_VALUE || b < Integer.MIN_VALUE) return 0;
        return (int)b;
    }
}
