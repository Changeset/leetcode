package greedy;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:19 2018/6/1
 * @ ModifiedBy:
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int indexS = 0, indexT = 0;
        while (indexT < t.length()) {
            if (t.charAt(indexT) == s.charAt(indexS)) {
                indexS++;
                if (indexS == s.length()) return true;
            }
            indexT++;
        }
        return false;
    }

    public static void main(String[] args) {
        IsSubsequence i = new IsSubsequence();
        System.out.println(i.isSubsequence("abc", "asadfbc"));
    }
}
