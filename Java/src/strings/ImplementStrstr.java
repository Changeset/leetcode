package strings;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 9:01 2018/3/5
 * @ ModifiedBy:
 */
public class ImplementStrstr {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
    public static void main(String[] args) {
        ImplementStrstr s = new ImplementStrstr();
        System.out.println(s.strStr("hello", "ll"));
    }
}
