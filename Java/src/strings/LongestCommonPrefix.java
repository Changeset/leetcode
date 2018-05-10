package strings;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 14:19 2018/3/1
 * @ ModifiedBy:
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] str) {
        if (str.length == 0) return "";
        String pre = str[0];
        for (int i = 1; i < str.length; i++) {
            while(str[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length()-1);
            }
        }
        return pre;
    }
}
