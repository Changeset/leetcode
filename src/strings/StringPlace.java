package strings;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 11:20 2018/3/10
 * @ ModifiedBy:
 */
public class StringPlace {
    public String stringReplace(String[] a, String[] b, String s) {
        int max = -1, index = -1;
        for (int i = 0; i < a.length; i++) {
            StringBuilder sb = new StringBuilder(s);
            String str = sb.toString();
            if (str.indexOf(a[i]) >= 0) {
                if (a[i].length() > max) {
                    max = a[i].length();
                    index = i;
                }
            }
        }
        if (index == -1) return s;
        return s.replace(a[index], b[index]);
    }
    private static String findLongestSubString2(String str) {
        if(str == null) return null;
        StringBuilder maxSubString = new StringBuilder("");
        char [] strCharArr = str.toCharArray();
        int [] charsIndex = new int[256];
        for(int index = 0; index < 256; index++) charsIndex[index] = -1;
        int startIndex = -1, oriStartIndex = startIndex, maxLen = 0;
        for(int index = 0; index < strCharArr.length; index++) {
            if(charsIndex[strCharArr[index]] > startIndex)
                startIndex = charsIndex[strCharArr[index]];
            if(index - startIndex > maxLen) {
                maxLen = index - startIndex;
                oriStartIndex = startIndex;
            }
            charsIndex[strCharArr[index]] = index;
        }
        for(int index =  oriStartIndex + 1; index < oriStartIndex + maxLen + 1; index++) {
            maxSubString.append(strCharArr[index]);
        }
        return maxSubString.toString();
    }

    public static void main(String[] args) {
        String s = "ababa";
        String[] a = {"ab", "aba"};
        String[] b = {"cc", "ccc"};
        StringPlace p = new StringPlace();
        System.out.println(p.stringReplace(a,b,s));
    }
}
