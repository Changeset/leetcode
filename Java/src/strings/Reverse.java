package strings;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:13 2018/3/1
 * @ ModifiedBy:
 */
public class Reverse {
    public String reverseString(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        for (int i = 0; i < n/2; i++) {
            char temp = ch[i];
            ch[i] = ch[n-i-1];
            ch[n-i-1] = temp;
        }
        return new String(ch);
    }
}
