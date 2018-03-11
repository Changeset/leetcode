package strings;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:59 2018/3/11
 * @ ModifiedBy:
 */
public class KMP {
    private final int R;
    private int[][] dfa;
    private char[] pattern;
    private String pat;

    public KMP(String pat) {
        this.R = 256;
        this.pat = pat;
        int m = pat.length();
        dfa = new int[R][m];
        dfa[pat.charAt(0)][0] = 1;
        for (int x = 0, j = 1; j < m; j++) {
            for (int c = 0; c < R; c++)
                dfa[c][j] = dfa[c][x];
            dfa[pat.charAt(j)][j] = j + 1;
            x = dfa[pat.charAt(j)][x];
        }
    }

    public int search(String txt) {
        int m = pat.length();
        int n = txt.length();
        int i, j;
        for (i = 0, j = 0; i < n && j < m; i++) {
            j = dfa[txt.charAt(i)][j];
        }
        if (j == m) return i - m;
        return n;
    }
    public static int search(String txt, String pattern) {
        int m = pattern.length();
        int n = txt.length();
        int[][] dfa = new int[256][m];
        dfa[pattern.charAt(0)][0] = 1;
        for (int x = 0, j = 1; j < m; j++) {
            for (int c = 0; c < 256; c++)
                dfa[c][j] = dfa[c][x];
            dfa[pattern.charAt(j)][j] = j + 1;
            x = dfa[pattern.charAt(j)][x];
        }
        int i, j;
        for (i = 0, j = 0; i < n && j < m; i++) {
            j = dfa[txt.charAt(i)][j];
        }
        if (j == m) return i - m;
        return n;
    }

    public int search(char[] text) {
        int m = pattern.length;
        int n = text.length;
        int i, j;
        for (i = 0, j = 0; i < n && j < m; i++) {
            j = dfa[text[i]][j];
        }
        if (j == m) return i - m;
        return n;
    }

    public static void main(String[] args) {
        String pattern = "ababac";
        String B = "abacabfababacad";
        System.out.println(KMP.search(B, pattern));
    }
}
