package sortandsearch;

import java.util.LinkedList;
import java.util.List;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 17:39 2018/8/24
 * @ ModifiedBy:
 */
public class LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        String longest = "";
        for (String dictWord : d) {
            int i = 0;
            for (char c : s.toCharArray())
                if (i < dictWord.length() && c == dictWord.charAt(i)) i++;

            if (i == dictWord.length() && dictWord.length() >= longest.length())
                if (dictWord.length() > longest.length() || dictWord.compareTo(longest) < 0)
                    longest = dictWord;
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestWordInDictionaryThroughDeleting l = new LongestWordInDictionaryThroughDeleting();
        List<String> list = new LinkedList<>();
        list.add("ale");
        list.add("apple");
        list.add("monkey");
        list.add("plea");
        String res = l.findLongestWord("abpcplea", list);
        System.out.println(res);
    }
}
