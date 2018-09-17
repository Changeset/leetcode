package math;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 21:11 2018/8/28
 * @ ModifiedBy:
 */
public class NumberOfOne {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfOne n = new NumberOfOne();
        System.out.println(n.NumberOf1(1));
    }
}
