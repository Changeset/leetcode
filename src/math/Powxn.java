package math;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 9:04 2018/3/27
 * @ ModifiedBy:
 */
public class Powxn {
    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE && x > 1) return 0;
        if (n == 0) return 1;
        if (n < 0) {
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }

    public static void main(String[] args) {
        Powxn p = new Powxn();
        System.out.println(p.myPow(2.100,3));
    }
}
