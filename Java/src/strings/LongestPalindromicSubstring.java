package strings;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 20:17 2018/3/13
 * @ ModifiedBy:
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) return "";
        if (s.length() == 1) return s;
        int min_start = 0, max_len = 1;
        char[] ch = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n;) {
            if (n - i <= max_len / 2) break;
            int j = i, k = i;
            while (k < s.length()-1 && ch[k+1] == ch[k])
                k++;
            i = k + 1;
            while (k < s.length()-1 && j > 0 && ch[k+1] == ch[j-1]){
                ++k;
                --j;
            }
            int new_len = k - j + 1;
            if (new_len > max_len) {
                min_start = j;
                max_len = new_len;
            }
        }
        return s.substring(min_start, max_len+min_start);
    }

    public String longestPalindromeSubstring(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = extend(s, i, i),
                    s2 = extend(s, i, i+1);
            if (s1.length() > max.length()) max = s1;
            if (s2.length() > max.length()) max = s2;
        }
        return max;
    }

    private String extend(String s, int i, int j) {
        for (; 0 <= i && j < s.length(); i--, j++)
            if (s.charAt(i) != s.charAt(j)) break;
        return s.substring(i + 1, j);
    }
    public static void main(String[] args) {
        String s = "cbbdbbasd";
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        System.out.println(l.longestPalindromeSubstring(s));
    }
}
