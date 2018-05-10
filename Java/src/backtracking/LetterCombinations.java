package backtracking;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 20:31 2018/3/18
 * @ ModifiedBy:
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits.isEmpty()) return res;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        int n = digits.length();
        for (int i = 0; i < n; i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (res.peek().length() == i) {
                String t = res.remove();
                for (char s : mapping[x].toCharArray())
                    res.add(t + s);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LetterCombinations c = new LetterCombinations();
        String digits = "23";
        System.out.println(c.letterCombinations(digits));
    }
}
