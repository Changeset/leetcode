package strings;

import java.util.*;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:05 2018/4/24
 * @ ModifiedBy:
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList), vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        for (int len = 1; !q.isEmpty(); len++) {
            for (int i = q.size(); i > 0; i--) {
                String w = q.poll();
                if (w.equals(endWord)) return len;

                for (int j = 0; j < w.length(); j++) {
                    char[] ch = w.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == w.charAt(j)) continue;
                        ch[j] = c;
                        String nb = String.valueOf(ch);
                        if (dict.contains(nb) && vis.add(nb)) q.offer(nb);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder w = new WordLadder();
        String begin = "los";
        String end = "lot";
        List<String> wordList = new LinkedList<>();
        wordList.add("los");
        wordList.add("tos");
        wordList.add("tot");
        wordList.add("lot");
        System.out.println(w.ladderLength(begin, end, wordList));
    }
}
