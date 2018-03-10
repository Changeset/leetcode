package strings;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 11:47 2018/3/10
 * @ ModifiedBy:
 */
public class GetString {

    public String getString(int n) {
        if (n < 1) return "";
        int m = (int)Math.pow(2, n) -1;
        char[] s = new char[m];
        help(s, 0, m-1, '0');
        String str = new String(s);
        return str;
    }
    void help(char[] s, int l, int r, char c) {
        if (l > r) return;
        int m = l + (r -l) / 2;
        s[m] = c;
        help(s, l, m-1, '0');
        help(s, m+1, r, '1');
    }
    public static void main(String[] args) {
        GetString s = new GetString();
        System.out.println(s.getString(2));
    }
}
