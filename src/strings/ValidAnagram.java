package strings;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:57 2018/3/1
 * @ ModifiedBy:
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == t) return false;
        int lS = s.length(), lT = t.length();
        if (lS != lT) return false;
        int[] freqS = new int[256],
                freqT = new int[256];
        for (int i = 0; i < lS; i++) {
            freqS[s.charAt(i) - 'a']++;
            freqT[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 256; i++) {
            if (freqS[i] != freqT[i]) return false;
        }
        return true;
    }
}
