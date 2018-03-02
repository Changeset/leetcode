package sortandsearch;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 19:58 2018/3/2
 * @ ModifiedBy:
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        if (n <= 1) return n;
        else return helper(1, n);
    }

    public int helper(int lo, int hi) {
        if (lo == hi) return lo;
        int mid = lo + (hi - lo) / 2;
        if (isBadVersion(mid)) return helper(lo, mid);
        else return helper(mid + 1, hi);
    }

    public static void main(String[] args) {
        FirstBadVersion f = new FirstBadVersion();
        System.out.println(f.firstBadVersion(2126753390));
    }

    public boolean isBadVersion(int n) {
        if (n >= 1702766719 && n <= Integer.MAX_VALUE)
            return true;
        else return false;
    }
}
