package hashtable;

import java.util.*;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 20:51 2018/4/11
 * @ ModifiedBy:
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        String res = "";
        int[] hash = new int[256];
        int minLen = Integer.MAX_VALUE, start = 0, end = 0, counter = t.length(), head = 0;
        Arrays.fill(hash, 0);
        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)]++;
        }
        while (end < s.length()) {
            if (hash[s.charAt(end++)]-- > 0) counter--;
            while (counter == 0) {
                if (end - start < minLen) minLen = end - (head = start);
                if (hash[s.charAt(start++)]++ == 0) counter++;
            }
        }
        return minLen == Integer.MAX_VALUE ? res : s.substring(head, head+minLen);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        String S = "ADOBECODEBANC", T = "ABC";
        System.out.println(m.minWindow(S, T));
    }
}
