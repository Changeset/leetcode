package strings;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 14:50 2018/4/9
 * @ ModifiedBy:
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if(res != 0) break;
            }
            else res++;
        }
        return res;
    }

    public static void main(String[] args) {
        LengthOfLastWord l = new LengthOfLastWord();
        System.out.println(l.lengthOfLastWord("a "));
    }
}
