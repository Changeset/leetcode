package strings;

import java.util.*;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 18:45 2018/3/13
 * @ ModifiedBy:
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        if (strs == null || strs.length == 0)
            return new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        return new ArrayList<List<String>>(map.values());
    }


    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(g.groupAnagrams(strs));
    }
}
