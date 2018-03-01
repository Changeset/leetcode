package strings;

import java.util.*;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:37 2018/3/1
 * @ ModifiedBy:
 */
public class FirstUniqueCh {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        Set<Character> set = new HashSet<Character>();
        char[] ch = s.toCharArray();
        int n = ch.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(ch[i])) {
                map.put(ch[i], 2);
            }
            else map.put(ch[i], 1);
        }
        for (Character c : map.keySet()) {
            Character key = c;
            Integer value = map.get(key);
            if (value == 1) return s.indexOf(c);
        }
        return -1;
    }

    public int firstUniqChar1(String s) {
        int freq[] = new int[256];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
