package strings;

import java.util.HashMap;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 19:56 2018/3/13
 * @ ModifiedBy:
 */
public class LongestSubstringWithoutRepeat {
//    public int lengthOfLongestSubstring(String s) {
//        int curLength = 0, maxLength = 0;
//        if (s.length() == 0) return 0;
//        char[] ch = s.toCharArray();
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < ch.length; i++) {
//            if (!map.containsKey(ch[i])) {
//                map.put(ch[i], i);
//                curLength++;
//            }
//            else {
//                int index = map.get(ch[i]);
//                map.clear();
//                for (int j = index+1; j <= i; j++)
//                    map.put(ch[j], j);
//                curLength = i - index;
//            }
//            maxLength = Math.max(curLength, maxLength);
//        }
//        return maxLength;
//    }

    public int lengthOfLongestSubstring(String s) {
        int curLength = 0, maxLength = 0;
        if (s.length() == 0) return 0;
        int[] map = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] == 0) {
                map[s.charAt(i)] = i;
                curLength++;
            } else {
                if(curLength > i - map[s.charAt(i)]) {
                    curLength = i - map[s.charAt(i)];
                    map[s.charAt(i)] = i;
                }
                else curLength++;
            }
            maxLength = Math.max(curLength, maxLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "tmmzuxt";
        LongestSubstringWithoutRepeat l = new LongestSubstringWithoutRepeat();
        System.out.println(l.lengthOfLongestSubstring(s));
    }
}
